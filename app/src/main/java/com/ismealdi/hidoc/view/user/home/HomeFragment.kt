package com.ismealdi.hidoc.view.user.home

import android.content.Context
import android.os.Handler
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.ismealdi.hidoc.R
import com.ismealdi.hidoc.base.AmFragment
import com.ismealdi.hidoc.struct.Article
import com.ismealdi.hidoc.struct.User
import com.ismealdi.hidoc.utils.components.slider.AmImage
import com.ismealdi.hidoc.utils.components.slider.AmSliderAdapter
import com.ismealdi.hidoc.utils.components.slider.AmSliderTransformation
import com.ismealdi.hidoc.view.user.home.adapter.ArticleAdapter
import com.ismealdi.hidoc.view.user.home.adapter.DoctorAdapter
import com.ismealdi.hidoc.view.user.home.adapter.SpecialistAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

/**
 * Created by Al
 * on 06/04/19 | 03:27
 */
class HomeFragment : AmFragment(R.layout.fragment_home, R.string.title_home), HomeContract.View {
	
	override var presenter: HomeContract.Presenter? = null
	
	private var sliderCurrentPage = 0
	private var sliderNumberPage = 0
	private val sliderDelay = 3000L
	
	private var specialistsAdapter: SpecialistAdapter? = null
	private var doctorsAdapter: DoctorAdapter? = null
	private var articlesAdapter: ArticleAdapter? = null
	
	override fun initView() {
		
		amActivity?.let {
			presenter = HomePresenter(this, it)
			initAdapter(it)
			initSlider(it)
			initLists(it)
		}
	}

    private fun initAdapter(context: Context) {
        specialistsAdapter = SpecialistAdapter(
                listOf("Dentist", "Internist", "Neurologist", "Orthopedic", "ENT", "Anesthesia", "Dermatologist", "Geriatric", "Hematologist", "Radiologist"),
                context, isMore= true)

        doctorsAdapter = DoctorAdapter(listOf(User(), User(), User()), context)
        articlesAdapter = ArticleAdapter(listOf(Article(), Article(), Article(), Article()), context)
    }

    private fun initLists(context: Context) {
		gridSpecialists.layoutManager = GridLayoutManager(context, 5)
		gridSpecialists.adapter = specialistsAdapter
		
		gridDoctors.layoutManager = LinearLayoutManager(context, LinearLayout.HORIZONTAL, false)
		gridDoctors.adapter = doctorsAdapter
		
		gridArticles.layoutManager = LinearLayoutManager(context, LinearLayout.HORIZONTAL, false)
		gridArticles.adapter = articlesAdapter
	}
	
	private fun initSlider(context: Context) {
		val slideList = listOf(
			AmImage("https://d1bpj0tv6vfxyp.cloudfront.net/slider/20190301132637.3381657571667.jpg", title= "Get Up To 20% Off", subTitle= "Medical Checkups"),
			AmImage("https://d1bpj0tv6vfxyp.cloudfront.net/slider/20190206100027.128-1294346682.jpg", title= "Merdeka Days 25% Off", subTitle= "Medical Checkups")
		)
		
		sliderNumberPage = slideList.size
		
		slider.adapter = AmSliderAdapter(context, slideList)
		sliderIndicator.setupWithViewPager(slider)
		slider.setPageTransformer(true, AmSliderTransformation())
		
		val handler = Handler()
		val update = Runnable {
			if (sliderCurrentPage == sliderNumberPage) {
				sliderCurrentPage = 0
			}
			
			slider?.setCurrentItem(sliderCurrentPage++, true)
		}
		
		val swipeTimer = Timer()
		swipeTimer.schedule(object : TimerTask() {
			override fun run() {
				handler.post(update)
			}
		}, sliderDelay, sliderDelay)
	}
	
}