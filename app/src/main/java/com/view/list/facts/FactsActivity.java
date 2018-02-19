package com.view.list.facts;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;



import com.view.list.facts.model.NewsFeed;
import com.view.list.facts.model.NewsFeedList;
import com.view.list.facts.networking.Service;

import javax.inject.Inject;

public class FactsActivity extends BaseApp implements FactsView ,SwipeRefreshLayout.OnRefreshListener{
    private RecyclerView list;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Inject
    public Service service;
    ProgressBar progressBar;
    private Toolbar toolbar;
    private FactsAdapter adapter;
    private FactsPresenter presenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        renderView();
        init();
        getFeeds().inject(this);
        presenter = new FactsPresenter(service, this);
        presenter.getNewsFeedList();
    }
    public  void renderView(){
        setContentView(R.layout.activity_facts);
        list = findViewById(R.id.list);
        progressBar = findViewById(R.id.progress);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST, 0));
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);
    }
    @Override
    public void onRefresh() {
        presenter.getNewsFeedList();
        swipeRefreshLayout.setRefreshing(false);
        progressBar.setVisibility(View.GONE);
    }
    public void init(){
        list.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {

    }
    @Override
    public void getNewsFeedListSuccess(NewsFeedList newsFeedListResponse) {
        adapter = new FactsAdapter(getApplicationContext(), newsFeedListResponse.getNewsFeed(),
                new FactsAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(NewsFeed Item) {
                        Toast.makeText(getApplicationContext(), Item.getTitle(),
                                Toast.LENGTH_LONG).show();
                    }
                });
        toolbar.setTitle(newsFeedListResponse.getNewsheadertitle());
        list.setAdapter(adapter);

    }
}
