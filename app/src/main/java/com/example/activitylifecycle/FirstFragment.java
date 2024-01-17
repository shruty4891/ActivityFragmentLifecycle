package com.example.activitylifecycle;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.activitylifecycle.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment implements PassData {
    PassData passData;

    @Override
    public void passDataInSvreen() {
        Log.i(TAG, "I am called from first fragment using interface");
    }

    private FragmentFirstBinding binding;
    private static final String TAG = "FirstFragmentActivityTag";
    private ItemViewModel viewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        passData = (PassData) context;
        Log.i(TAG, "onAttach() callback started");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate() callback started");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView() callback started");
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "onViewCreated() callback started");

        viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);

        binding.buttonFirst.setOnClickListener(view1 -> {
            binding.textviewFirst.setText("ygugyuyygygygu");
//            viewModel.selectItem("hjhjhjhj");
            passData.passDataInSvreen();

//            getActivity().getSupportFragmentManager().beginTransaction()
//                    .setReorderingAllowed(true)
//                    .replace(R.id.fragment_container_view, SecondFragment.class, null)
//                    .addToBackStack(null)
//                    .commit();
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