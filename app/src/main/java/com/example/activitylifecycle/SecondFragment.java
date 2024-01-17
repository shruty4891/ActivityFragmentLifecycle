package com.example.activitylifecycle;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.activitylifecycle.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment implements PassData {

    @Override
    public void passDataInSvreen() {
        Log.i(TAG, "I am calling from second fragment using interface");
    }

    private FragmentSecondBinding binding;
    private ItemViewModel viewModel;
    private static final String TAG = "SecondFragmentActivityTag";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach() callback started");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate() callback started");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        Log.i(TAG, "onCreateView() callback started");
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "onViewCreated() callback started");
        viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        viewModel.getSelectedItem().observe(requireActivity(), item -> {
            // Perform an action with the latest item data.
            Log.i(TAG, "I am called in Second Fragment");

        });
        binding.buttonSecond.setOnClickListener(view1 -> {
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart() callback started");
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume() callback started");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause() callback started");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop() callback started");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy() callback started");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView() callback started");
        binding = null;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach() callback started");
    }
}