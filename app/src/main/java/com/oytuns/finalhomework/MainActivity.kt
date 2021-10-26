package com.oytuns.finalhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ListAdapter
import androidx.lifecycle.MutableLiveData
import com.oytuns.finalhomework.model.Cities
import com.oytuns.finalhomework.repository.LocationRepository
import com.oytuns.finalhomework.service.WeatherAPI
import com.oytuns.finalhomework.service.WeatherAPIService
import com.oytuns.finalhomework.viewmodel.SearchViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_search.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {


    private val cityApiService = WeatherAPIService()
    private val disposable = CompositeDisposable()



    var locations = MutableLiveData<List<Cities>>()


/*    val local = Cities(1,"İzmir","Izmır","Turkey",15.5,14.4)
    val local2 = Cities(2,"Ankara","Ankara","Turkey",15.6,14.7)
    val local3 = Cities(3,"İstanbul","İstanbul","Turkey",15.6,14.3)
    val local4 = Cities(4,"Adana","Adana","Turkey",15.9,12.3)

    val denemeListesi = arrayListOf<String>(local.name,local2.name,local3.name,local4.name)*/

    fun getDataWithRetrofit() : WeatherAPI{

        fun locationRepository(api : WeatherAPI) = LocationRepository(api)

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://api.weatherapi.com/v1/")
            .build()
            .create(WeatherAPI::class.java)

    }

/*    private fun getDataFromAPI(){
        disposable.add(
            cityApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Cities>>(){
                    override fun onSuccess(t: List<Cities>?) {
                        locations.value = t
                    }
                    override fun onError(e: Throwable?) {
                        e?.printStackTrace()
                    }
                })
        )
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_search)
        //getDataFromAPI()
        //val liste = WeatherAPIService.init()
        val menuList = arrayListOf<MutableLiveData<List<Cities>>>()


        println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
        println(menuList)
        //println(menuList.get(0).value)
        //println(liste.toString())
        println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")

        val editText : AutoCompleteTextView = findViewById(R.id.searchBar)
        val adapter = ArrayAdapter<MutableLiveData<List<Cities>>>(this,android.R.layout.simple_list_item_1,menuList)
        editText.setAdapter(adapter)

        //Listeden seçilen konuma tıklandığında ne olacağı burada gerçekleştiriliyor.
        searchBar.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position).toString()
            nonSelect.text = selectedItem
        }

        /*postToList()

        viewPager.adapter = ViewPagerAdapter(titleList,descList,imagesList)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL*/
    }
/*
    private fun addToList(title:String,description:String,image:Int){
        titleList.add(title)
        descList.add(description)
        imagesList.add(image)

    }

    private fun postToList(){
        for(i in 1..5){
            addToList("Title $i","Description $i", R.mipmap.ic_launcher_round)
        }
    }*/
}