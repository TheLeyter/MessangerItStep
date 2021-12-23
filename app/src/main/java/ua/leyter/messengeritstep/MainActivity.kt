package ua.leyter.messengeritstep

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.*
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var drawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.navController

        drawerLayout = findViewById(R.id.drawer_layout)
        nav_view.setupWithNavController(navController)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.nav_view)) { root, windowInset ->
            val inset = windowInset.getInsets(WindowInsetsCompat.Type.systemBars())
            root.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                bottomMargin = inset.bottom
            }
            findViewById<NavigationView>(R.id.nav_view)
                .getHeaderView(0).findViewById<View>(R.id.constraintHeader)
                .updateLayoutParams<ViewGroup.MarginLayoutParams> {
                    topMargin = inset.top
            }
            WindowInsetsCompat.CONSUMED
        }

        findViewById<View>(R.id.logoutBtn).setOnClickListener {
            navController.navigate(R.id.loginView)
            drawerLayout?.closeDrawer(GravityCompat.START)
        }
    }

    override fun onBackPressed() {
        if (drawerLayout?.isDrawerOpen(GravityCompat.START) == true) {
            drawerLayout?.closeDrawer(GravityCompat.START) }
        else {
            super.onBackPressed()
        }
    }

    fun openCloseNavigationDrawer() {
        if (drawerLayout?.isDrawerOpen(GravityCompat.START) == true) {
            drawerLayout?.closeDrawer(GravityCompat.START)
        } else {
            drawerLayout?.openDrawer(GravityCompat.START)
        }
    }

    fun setStatusBarTransparent(activity: Activity, view: View) {
        activity.apply {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            window.statusBarColor = Color.TRANSPARENT
            window.statusBarColor = ContextCompat.getColor(this, R.color.black30p)
            WindowCompat.setDecorFitsSystemWindows(window, false)
            ViewCompat.setOnApplyWindowInsetsListener(view) { root, windowInset ->
                val inset = windowInset.getInsets(WindowInsetsCompat.Type.systemBars())
                root.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                    leftMargin = inset.left
                    bottomMargin = inset.bottom
                    rightMargin = inset.right
                    topMargin = inset.top
                }
                WindowInsetsCompat.CONSUMED
            }
        }
    }
}