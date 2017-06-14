package com.wp.practise.view;

import com.wp.practise.framework.view.builder.context.impl.MyBuildContext;
import com.wp.practise.model.User;

/**
 * Created by Wang Peng on 2017/6/14.
 */
public class UserView {

    private final User user;

    private MyBuildContext myBuildContext;

    public UserView(User user, MyBuildContext myBuildContext){
        this.user = user;
        this.myBuildContext = myBuildContext;
    }

    public String getUserName(){
        return user.getUserName();
    }

    public String getCursor(){
        return user.getCusor();
    }

}
