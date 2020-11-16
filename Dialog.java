package com.vbh.hotel_billing_system;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialog extends AppCompatDialogFragment {
    EditText ino = null;
    private itemnolistener listener;

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder build = new AlertDialog.Builder(getActivity(), R.style.MyDialogTheme);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.popup, null);
        ino =view.findViewById(R.id.test);
        build.setView(view)
                .setTitle("Delete Item From List")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String itn = ino.getText().toString();
                        listener.senditemno(itn);
                    }
                });
        return build.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (itemnolistener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement itemnolistener");
        }
    }

}

interface itemnolistener
{
    void senditemno(String ino);

}


