package org.example.app.model;

import org.example.app.controller.AllPostsByUserIdController;
import org.example.app.controller.PostByIdController;
import org.example.app.controller.PostsController;
import org.example.app.view.PostsByUserIdView;
import org.example.app.view.PostsByIdView;
import org.example.app.view.PostsView;

public class AppModel {

    public void readUsers() {
        PostsModel model = new PostsModel();
        PostsView view = new PostsView();
        PostsController controller = new PostsController(model, view);
        controller.getUsers();
    }

    public void readUserById() {
        PostsModel model = new PostsModel();
        PostsByIdView view = new PostsByIdView();
        PostByIdController controller = new PostByIdController(model, view);
        controller.getUserById();
    }

    public void readAllPostsByUserId() {
        PostsModel model = new PostsModel();
        PostsByUserIdView view = new PostsByUserIdView();
        AllPostsByUserIdController controller = new AllPostsByUserIdController(model, view);
        controller.getAllPostsByUserId();
    }
}