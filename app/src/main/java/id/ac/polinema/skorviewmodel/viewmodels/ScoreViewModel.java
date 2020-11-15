package id.ac.polinema.skorviewmodel.viewmodels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;


import java.util.ArrayList;

import id.ac.polinema.skorviewmodel.fragments.ScoreFragment;
import id.ac.polinema.skorviewmodel.models.GoalScorer;
import id.ac.polinema.skorviewmodel.fragments.ScoreFragmentDirections;


public class ScoreViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<GoalScorer>> homeGoalScorerList =
        new MutableLiveData<>(new ArrayList<GoalScorer>());
    private final MutableLiveData<ArrayList<GoalScorer>> awayGoalScorerList =
            new MutableLiveData<>(new ArrayList<GoalScorer>());

    public int getHomeScorer(){
        return homeGoalScorerList.getValue().size();

    }

    public int getAwayScorer(){
        return awayGoalScorerList.getValue().size();
    }

    public void  setGoalScorer(String team, GoalScorer goalScorer){
        if (team.equals(ScoreFragment.HOME)){
            homeGoalScorerList.getValue().add(goalScorer);
        }else {
            awayGoalScorerList.getValue().add(goalScorer);
        }
    }

    public void onAddHomeClick(View view){
        ScoreFragmentDirections.GoalScorerAction action = ScoreFragmentDirections.goalScorerAction(ScoreFragment.HOME);
        Navigation.findNavController(view).navigate(action);
    }

    public void onAddAwayClick(View view){
        ScoreFragmentDirections.GoalScorerAction action = ScoreFragmentDirections.goalScorerAction(ScoreFragment.AWAY);
        Navigation.findNavController(view).navigate(action);
    }



}

