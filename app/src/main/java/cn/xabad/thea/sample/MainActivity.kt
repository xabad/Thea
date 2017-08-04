package cn.xabad.thea.sample

import android.graphics.Color
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import cn.xabad.thea.sample.PlusOneFragment.OnFragmentInteractionListener
import devlight.io.library.ntb.NavigationTabBar
import kotlinx.android.synthetic.main.activity_main.ntb_main
import java.util.concurrent.TimeUnit
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {

    }

    var models = mutableListOf<NavigationTabBar.Model>()
    var one: PlusOneFragment? = null
    var two: PlusOneFragment? = null
    var three: PlusOneFragment? = null
    var four: PlusOneFragment? = null

    lateinit var oneModel: NavigationTabBar.Model
    lateinit var twoModel: NavigationTabBar.Model
    lateinit var threeModel: NavigationTabBar.Model
    lateinit var fourModel: NavigationTabBar.Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ntb_main.badgeGravity = NavigationTabBar.BadgeGravity.TOP
        ntb_main.badgePosition = NavigationTabBar.BadgePosition.RIGHT
        ntb_main.animationDuration = 100

        oneModel = NavigationTabBar.Model.Builder(
            resources.getDrawable(R.drawable.tab_course_gray),
            Color.parseColor("#00000000"))
            .selectedIcon(resources.getDrawable(R.drawable.tab_course))
            .title("Teaching")
            .build()
        models.add(oneModel)
        twoModel = NavigationTabBar.Model.Builder(
            resources.getDrawable(R.drawable.tab_course_gray),
            Color.parseColor("#00000000"))
            .selectedIcon(resources.getDrawable(R.drawable.tab_course))
            .title("Teaching")
            .build()
        models.add(twoModel)
        threeModel = NavigationTabBar.Model.Builder(
            resources.getDrawable(R.drawable.tab_course_gray),
            Color.parseColor("#00000000"))
            .selectedIcon(resources.getDrawable(R.drawable.tab_course))
            .title("Teaching")
            .build()
        models.add(threeModel)
        fourModel = NavigationTabBar.Model.Builder(
            resources.getDrawable(R.drawable.tab_course_gray),
            Color.parseColor("#00000000"))
            .selectedIcon(resources.getDrawable(R.drawable.tab_course))
            .title("Teaching")
            .build()
        models.add(fourModel)


        ntb_main.models = models
        setSelection(0)

        ntb_main.onTabBarSelectedIndexListener = object : NavigationTabBar.OnTabBarSelectedIndexListener {
            override fun onStartTabSelected(model: NavigationTabBar.Model, index: Int) {

            }

            override fun onEndTabSelected(model: NavigationTabBar.Model, index: Int) {
                setTabSelection(index)
            }
        }

    }

    fun setSelection(index: Int) {
        ntb_main.modelIndex = index
        setTabSelection(index)
    }

    //全部hide掉，再显示选中的
    fun setTabSelection(tabSelection: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        when (tabSelection) {
            0 -> {
                if (one == null) {
                    one = PlusOneFragment.newInstance("one", "1")
                    transaction.add(R.id.id_content, one)
                } else {
                    transaction.show(one)
                }
                oneModel.badgeTitle = "99+"
                oneModel.showBadge()
            }

            1 -> if (two == null) {
                two = PlusOneFragment.newInstance("2", "2")
                transaction.add(R.id.id_content, two)
            } else {
                transaction.show(two)
            }
            2 -> if (three == null) {
                three = PlusOneFragment.newInstance("3", "3")
                transaction.add(R.id.id_content, three)
            } else {
                transaction.show(three)
            }
            3 -> if (four == null) {
                four = PlusOneFragment.newInstance("4", "4")
                transaction.add(R.id.id_content, four)
            } else {
                transaction.show(four)
            }
        }
        transaction.commit()

    }

    private fun hideFragments(transaction: FragmentTransaction) {
        if (one != null) {
            transaction.hide(one)
        }
        if (two != null) {
            transaction.hide(two)
        }
        if (three != null) {
            transaction.hide(three)
        }
        if (four != null) {
            transaction.hide(four)
        }
    }
}
