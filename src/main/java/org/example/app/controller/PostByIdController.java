package org.example.app.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.app.entity.Post;
import org.example.app.model.PostsModel;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.view.PostsByIdView;
import retrofit2.Response;

import java.util.Optional;

public class PostByIdController {

    PostsModel model;
    PostsByIdView view;

    public PostByIdController(PostsModel model, PostsByIdView view) {
        this.model = model;
        this.view = view;
    }

    public void getUserById() {
        view.getOutput(readUserById(
                Integer.parseInt(view.getData())
        ));
        AppStarter.startApp();
    }

    private String readUserById(int id) {
        Optional<Response<Post>> optional = model.fetchUserById(id);

        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {
            Gson gson = new Gson();
            Post post = gson.fromJson(String.valueOf(optional.get().body()),
                    new TypeToken<Post>() {
                    }.getType());

            return "Post_ID: " + post.getId() + "\nUser_id: " + post.getUserId() +
                    "\nTitle: " + post.getTitle() + "\nText: " + post.getBody() + "\n";
        }
    }
}
