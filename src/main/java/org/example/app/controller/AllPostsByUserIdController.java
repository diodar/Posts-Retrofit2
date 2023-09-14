package org.example.app.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.app.entity.Post;
import org.example.app.model.PostsModel;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.view.PostsByUserIdView;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class AllPostsByUserIdController {

    PostsModel model;
    PostsByUserIdView view;

    public AllPostsByUserIdController(PostsModel model, PostsByUserIdView view) {
        this.model = model;
        this.view = view;
    }

    public void getAllPostsByUserId() {
        view.getOutput(readAllPostsByUsersId(
                Integer.parseInt(view.getData())));
        AppStarter.startApp();
    }

    private String readAllPostsByUsersId(int id) {
        Optional<Response<List<Post>>> optional = model.fetchAllPostsByUserId(id);
        if (optional.isEmpty() || optional.get().body().isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {

            Gson gson = new Gson();
            List<Post> posts = gson.fromJson(String.valueOf(optional.get().body()),
                    new TypeToken<List<Post>>() {
                    }.getType());

            StringBuilder stringBuilder = new StringBuilder();
            AtomicInteger cnt = new AtomicInteger(0);
            String str;

            System.out.println("\nAll posts written by User_" + id + ":");

            for (Post post : posts) {
                str = "\n" + cnt.incrementAndGet() + ") Post_ID: " + post.getId() + "\n"
                        +  "Title: " + post.getTitle() + "\n"
                        + "Text: " + post.getBody() + "\n";
                stringBuilder.append(str);
            }

            return stringBuilder.toString();
        }
    }
}