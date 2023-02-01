package peacsoft;

import peacsoft.entity.InstagramAccount;
import peacsoft.entity.Post;
import peacsoft.entity.User;
import peacsoft.repositories.InstagramAccountRepositories;
import peacsoft.repositories.impl.InstagramAccountImpl;
import peacsoft.service.PostService;
import peacsoft.service.UserService;
import peacsoft.service.impl.PostServiceImpl;
import peacsoft.service.impl.UserServiceImpl;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        UserService userService = new UserServiceImpl();
        PostService postService = new PostServiceImpl();
        InstagramAccountRepositories instagramAccountRepositories = new InstagramAccountImpl();

        String number = "null";
        while (!number.equals("x")) {
            commands();
            System.out.print("Enter a command: ");
            number = new Scanner(System.in).nextLine();
            try {
                if (Character.isDigit(number.charAt(0))) {
                    switch (number) {
                        case "1" -> {
                            System.out.print("Write full user name: ");
                            String fullName = new Scanner(System.in).nextLine();
                            System.out.print("Writer year of brith: ");
                            int year = new Scanner(System.in).nextInt();
                            int month = new Random().nextInt(12);
                            int day = new Random().nextInt(31);
                            LocalDate dateOfBrith = LocalDate.of(year, month, day);
                            System.out.print("Write email: ");
                            String email = new Scanner(System.in).nextLine();
                            User user = new User(fullName, dateOfBrith, email);
                            System.out.println(userService.saveUser(user));
                        }
                        case "2" -> {
                            System.out.print("Write user id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(userService.getUserById(id));
                        }
                        case "3" -> userService.getAllUsers().forEach(System.out::println);
                        case "4" -> {
                            User user1 = new User();
                            System.out.print("Write user id in updated: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.print("Write full user name: ");
                            user1.setFullName(new Scanner(System.in).nextLine());
                            System.out.print("Writer year of brith: ");
                            user1.setDateOfBrith(LocalDate.of(new Scanner(System.in).nextInt(), new Random().nextInt(12), new Random().nextInt(31)));
                            System.out.print("Write email: ");
                            user1.setEmail(new Scanner(System.in).nextLine());
                            System.out.println(userService.updateUser(id, user1));
                        }
                        case "5" -> {
                            System.out.print("Write user id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(userService.deleteUserById(id));
                        }
                        case "6" -> {
                            System.out.print("Write exist email: ");
                            String email = new Scanner(System.in).nextLine();
                            System.out.println(userService.existByEmail(email));
                        }
                        case "7" -> {
                            System.out.print("Image (String): ");
                            String image = new Scanner(System.in).nextLine();
                            System.out.print("Write description: ");
                            String description = new Scanner(System.in).nextLine();
                            System.out.print("Write publication year: ");
                            LocalDate date = (LocalDate.of(new Scanner(System.in).nextInt(), new Random().nextInt(12), new Random().nextInt(31)));
                            Post post = new Post(image, description, date);
                            postService.savePost(post);
                        }
                        case "8" -> {
                            System.out.print("Write post id: ");
                            System.out.println(postService.getPostById(new Scanner(System.in).nextLong()));
                        }
                        case "9" -> postService.getAllPosts().forEach(System.out::println);
                        case "10" -> {
                            Post post = new Post();
                            System.out.print("Write post id in update: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.print("Image (String): ");
                            post.setImage(new Scanner(System.in).nextLine());
                            System.out.print("Write description: ");
                            post.setDescription(new Scanner(System.in).nextLine());
                            System.out.print("Write publication year: ");
                            post.setPublicationDate(LocalDate.of(new Scanner(System.in).nextInt(), new Random().nextInt(12), new Random().nextInt(31)));
                            System.out.println(postService.updatePost(id, post));
                        }
                        case "11" -> {
                            System.out.print("Write post id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(postService.deletePostById(id));
                        }
                        case "12" -> {
                            System.out.print("Write post id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.print("Write new description: ");
                            String description = new Scanner(System.in).nextLine();
                            System.out.println(postService.editDescription(id, description));
                        }
                        case "13" -> {
                            System.out.print("Write user name: ");
                            String userName = new Scanner(System.in).nextLine();
                            System.out.print("Write login: ");
                            String login = new Scanner(System.in).nextLine();
                            System.out.print("Write password: ");
                            String password = new Scanner(System.in).nextLine();
                            InstagramAccount instagramAccount = new InstagramAccount(userName, login, password);
                            System.out.println(instagramAccountRepositories.saveAccount(instagramAccount));
                        }
                        case "14" -> {
                            System.out.print("Write account id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(instagramAccountRepositories.getAccountById(id));
                        }
                        case "15" -> instagramAccountRepositories.getAllAccounts().forEach(System.out::println);
                        case "16" -> {
                            System.out.print("Write account id in updated: ");
                            Long id = new Scanner(System.in).nextLong();
                            InstagramAccount instagramAccount = new InstagramAccount();
                            System.out.print("Write user name: ");
                            instagramAccount.setUserName(new Scanner(System.in).nextLine());
                            System.out.print("Write login: ");
                            instagramAccount.setLogin(new Scanner(System.in).nextLine());
                            System.out.print("Write password: ");
                            instagramAccount.setPassword(new Scanner(System.in).nextLine());
                            System.out.println(instagramAccountRepositories.updateAccount(id, instagramAccount));
                        }
                        case "17" -> {
                            System.out.print("Write account id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(instagramAccountRepositories.deleteAccountById(id));
                        }
                        case "18" -> {
                            System.out.print("Write account id in changed password: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.print("Write new password: ");
                            String password = new Scanner(System.in).nextLine();
                            System.out.println(instagramAccountRepositories.changePassword(id, password));
                        }
                        case "19" -> {
                            System.out.print("Write account id: ");
                            Long accountId = new Scanner(System.in).nextLong();
                            System.out.print("Write user id: ");
                            Long userId = new Scanner(System.in).nextLong();
                            instagramAccountRepositories.assignUserToInstagramAccount(accountId, userId);
                        }
                        case "20" -> {
                            System.out.print("Write account id: ");
                            Long accountId = new Scanner(System.in).nextLong();
                            System.out.print("Write post id: ");
                            Long postId = new Scanner(System.in).nextLong();
                            instagramAccountRepositories.assignPostToInstagramAccount(accountId, postId);
                        }
                    }
                } else {
                    throw new RuntimeException();
                }
            } catch (RuntimeException e) {
                System.out.println("It is not a button.");
            }
        }
    }

    public static void commands() {
        System.out.println("""
                Press 1 to save user;
                Press 2 to get user by id;
                Press 3 to get all users;
                Press 4 to update user;
                Press 5 to delete user by id;
                Press 6 to exist by email;
                                
                Press 7 to save post;
                Press 8 to get post by id;
                Press 9 to get all posts;
                Press 10 to update post;
                Press 11 to delete post by id;
                Press 12 to edit description in post;
                                
                Press 13 to save instagram account;
                Press 14 to get account by id;
                Press 15 to get all accounts;
                Press 16 to update account by id;
                Press 17 to delete account by id;
                Press 18 to change password;
                Press 19 to login user to instagram account;
                Press 20 to assign post to instagram account;
                """);
    }

}
