package zqx.rj.com.playandroid.system.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * author：  HyZhan
 * created： 2018/10/22 19:42
 * desc：    TODO
 */
class TopTreeAdapter(fm: FragmentManager, val titles: List<String>, val fragments: List<Fragment>)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence? = titles[position]
}