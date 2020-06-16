package com.shujiel.leetcodepractices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private List<String> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);

        removeNum(nums);

        initData();
        initView();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new HomeAdapter());
    }

    private void initData() {
        mDataList = new ArrayList<>();
        mDataList.add("删除排序数组中的重复项");
        mDataList.add("test");
    }

    class HomeAdapter extends  RecyclerView.Adapter<HomeAdapter.MyHolder>{
        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_layout,parent,false);
            MyHolder holder = new MyHolder(itemView);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            holder.mTextView.setText(mDataList.get(position));
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }

        class MyHolder extends RecyclerView.ViewHolder{
            TextView mTextView;
            public MyHolder(@NonNull View itemView) {
                super(itemView);
                mTextView = itemView.findViewById(R.id.tv);
            }
        }
    }

    private void removeNum(int[] nums) {
        for (int i = 0;i < nums.length;i ++){

        }
    }


    /**
         *   删除排序数组中的重复项
         * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
         *
         * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
         *
         *
         *
         * 示例 1:
         *
         * 给定数组 nums = [1,1,2],
         *
         * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
         *
         * 你不需要考虑数组中超出新长度后面的元素。
         * 示例 2:
         *
         * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
         *
         * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
         *
         * 你不需要考虑数组中超出新长度后面的元素。
         *
         *
         * 说明:
         *
         * 为什么返回数值是整数，但输出的答案是数组呢?
         *
         * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
         *
         * 你可以想象内部操作如下:
         *
         * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
         * int len = removeDuplicates(nums);
         *
         * // 在函数里修改输入数组对于调用者是可见的。
         * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
         * for (int i = 0; i < len; i++) {
         *     print(nums[i]);
         * }
         */

        private int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0){
                return  0;
            }

            int back = 0;
            for (int front = 1;front < nums.length;front ++){
                if (nums[back] != nums[front]){
//                    back = back + 1;
                    back ++;
                    nums[back] = nums[front];
                    Log.d(TAG,"removeDuplicates()" + "back = " + back + " front = " + front + " num[" + back + "] = " + nums[back]);
                }
            }

            return back + 1;
        }




}
