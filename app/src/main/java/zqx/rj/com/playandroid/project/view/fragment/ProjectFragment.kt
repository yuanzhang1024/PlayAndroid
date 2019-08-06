package zqx.rj.com.playandroid.project.view.fragment

import androidx.lifecycle.Observer
import androidx.fragment.app.Fragment
import com.zhan.mvvm.mvvm.LifecycleFragment
import kotlinx.android.synthetic.main.fragment_project.*
import zqx.rj.com.playandroid.R
import zqx.rj.com.playandroid.project.adapter.ViewPagerAdapter
import zqx.rj.com.playandroid.project.data.bean.ProjectTreeRsp
import zqx.rj.com.playandroid.project.vm.ProjectViewModel

/**
 * author：  HyZhan
 * created： 2018/10/27 16:11
 * desc：    TODO
 */
class ProjectFragment : LifecycleFragment<ProjectViewModel>() {

    private lateinit var mAdapter: ViewPagerAdapter
    private val titles by lazy { ArrayList<String>() }
    private val fragments by lazy { ArrayList<Fragment>() }

    override fun getLayoutId(): Int = R.layout.fragment_project

    override fun initView() {
        super.initView()

        mTlCategory.setupWithViewPager(mVpFragments)
    }

    override fun initData() {
        super.initData()

        // 获取项目 分类数据
        viewModel.getProjectTree()
    }

    override fun dataObserver() {
        viewModel.projectTreeData.observe(this, Observer {
            initTitles(it)
            initFragment(it)
        })
    }

    private fun initTitles(dataList: List<ProjectTreeRsp>) {
        for (item in dataList) {
            titles.add(item.name)
        }
    }

    private fun initFragment(dataList: List<ProjectTreeRsp>) {
        for (projectTreeRsp in dataList) {
            fragments.add(ProjectTabFragment.getNewInstance(projectTreeRsp.id))
        }

        mAdapter = ViewPagerAdapter(titles, fragments, childFragmentManager)
        mVpFragments.adapter = mAdapter
    }
}