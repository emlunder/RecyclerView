package com.example.cmltdstudent.class12_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> persons;
    private PersonAdapter personsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        personsAdapter = new PersonAdapter(persons, this);
        recyclerView.setAdapter(personsAdapter);
    }

    public void addRandomPerson(View view) {
        persons.add(getRandomPerson());
        personsAdapter.notifyDataSetChanged();
    }

    //3 items to begin with
    private void initialData() {
        persons = new ArrayList<>();
        persons.add(new Person("Bill Clinton", "1993-2001", R.drawable.clinton));
        persons.add(new Person("George W. Bush", "2001-2009", R.drawable.bush));
        persons.add(new Person("Barack Obama", "2009-2017", R.drawable.obama));
    }

    private Person getRandomPerson() {
        int num = (int) (Math.random() * 3);
        if (num == 0)
            return new Person("Bill Clinton", "1993-2001", R.drawable.clinton);
        else if (num == 1)
            return new Person("George W. Bush", "2001-2009", R.drawable.bush);
        else
            return new Person("Barack Obama", "2009-2017", R.drawable.obama);
    }
}

