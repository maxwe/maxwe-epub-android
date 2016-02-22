package org.maxwe.epub.android.lib;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.maxwe.epub.android.lib.core.model.IBook;
import org.maxwe.epub.android.lib.model.EPub;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2016-01-05 17:27.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: EPub渲染器
 */
public class EPubRender extends ViewPager implements View.OnLongClickListener {

    /**
     * 屏幕的宽度
     */
    private int screenWidth;
    /**
     * 屏幕的高度
     */
    private int screenHeight;

    private int currentPageNum = 0;

    /**
     * 定义三张页面
     */
    private PageView firstPageView;
    private PageView secondPageView;
    private PageView thirdPageView;

    /**
     * 页面的集合
     * 初始化三张页面
     * 轮转式显示PageDrawer内容
     */
    private final LinkedList<PageView> pageViews = new LinkedList<>();
    /**
     * pageView 适配器
     */
    private final PagerAdapter pagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }

        @Override
        public int getItemPosition(Object object) {
            int itemPosition = this.getItemPosition(object);
            if (itemPosition < 0) {
                return itemPosition;
            }
            return super.getItemPosition(object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            position %= pageViews.size();
            if (position < 0) {
                position = pageViews.size() + position;
            }

            PageView pageView = pageViews.get(position);
            pageView.reset();
            ViewParent parent = pageView.getParent();
            if (parent != null) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.removeView(pageView);
            }
            container.addView(pageView);
            return pageView;
        }
    };

    private OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {
            System.out.println("onPageScrolled: " + i + "; " + v +"; " + i1);
        }

        @Override
        public void onPageSelected(int i) {
            System.out.println("onPageSelected: " + i );
            if (i > currentPageNum) {
                /**
                 * 向右翻页
                 */
                currentPageNum++;
                System.out.println("向右翻页 ======== " + i + " " + currentPageNum);
                pageViews.get(Math.abs(i + 1) % 3).setPageIndex(pageViews.get(Math.abs(i) % 3).getPageIndex() + 1);
            } else {
                /**
                 * 向左翻页
                 */
                currentPageNum--;
                System.out.println("向左翻页 ======== " + i + " " + currentPageNum);
                pageViews.get(Math.abs(i - 1) % 3).setPageIndex(pageViews.get(Math.abs(i) % 3).getPageIndex() - 1);
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {
            System.out.println("onPageScrollStateChanged: " + i );
        }
    };

    private EPub ePub;
    private EPubRenderConfigure ePubRenderConfigure = new EPubRenderConfigure();
    public EPubRender(Context context,EPub ePub,EPubRenderConfigure ePubRenderConfigure) {
        super(context);
        this.ePub = ePub;
        this.initView();
    }

    /**
     * 页面初始化
     * 在阶段性排版完成后执行
     * 初始化执政页面和在野页面
     */
    private void initView() {
        this.setBackgroundColor(Color.WHITE);
        /**
         * 初始化三张页面
         */
        this.firstPageView = new PageView(this.getContext(), "第一页").setPageIndex(0);
        this.secondPageView = new PageView(this.getContext(), "第二页").setPageIndex(1);
        this.thirdPageView = new PageView(this.getContext(), "第三页").setPageIndex(2);

        /**
         * 初始化页面集合
         */
        this.pageViews.add(this.firstPageView);
        this.pageViews.add(this.secondPageView);
        this.pageViews.add(this.thirdPageView);

        this.firstPageView.setOnLongClickListener(this);
        this.secondPageView.setOnLongClickListener(this);
        this.thirdPageView.setOnLongClickListener(this);

        this.setOnPageChangeListener(this.onPageChangeListener);
        this.setAdapter(this.pagerAdapter);
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.screenWidth = MeasureSpec.getSize(widthMeasureSpec);
        this.screenHeight = MeasureSpec.getSize(heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}