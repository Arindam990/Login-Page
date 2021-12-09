package com.example.loginpage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.loginpage.databinding.LoginFragmentBinding;

public class LoginFormFragment extends Fragment {

    LoginFragmentBinding binding;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String PASSWORD_PATTERN = ("^" +
            "(?=.*[@#$%^&+=])" +                                            // at least 1 special character
            "(?=\\S+$)" +                                                  // no white spaces
            ".{4,}" +                                                     // at least 4 characters
            "$");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = LoginFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.EmailEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(requireActivity(), "Enter email", Toast.LENGTH_SHORT).show();
            }
        });


        binding.PasswordEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireActivity(), "Enter password", Toast.LENGTH_SHORT).show();
            }
        });
        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(binding.EmailEditText.getText().toString()) && binding.EmailEditText.getText().toString().trim().matches(emailPattern)) {
                    Toast.makeText(requireActivity(), "valid email address", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(requireActivity(), "email not valid", Toast.LENGTH_SHORT).show();
                }
                if (!TextUtils.isEmpty(binding.PasswordEditText.getText().toString()) && binding.PasswordEditText.getText().toString().trim().matches(PASSWORD_PATTERN)) {
                    Toast.makeText(requireActivity(), "valid password", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(requireActivity(), "invalid password", Toast.LENGTH_SHORT).show();
                }
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_loginFormFragment_to_fragment1);


            }


        });
        binding.SignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(requireActivity(), "Signup", Toast.LENGTH_SHORT).show();
            }
        });
        binding.ForgotPButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireActivity(), "Forgot", Toast.LENGTH_SHORT).show();
            }
        });
    }
}