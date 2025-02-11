package D_11_02_25;

import java.util.*;
class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;
    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
    public void addFriend(int friendId) {
        if (!friendIds.contains(friendId)) {
            friendIds.add(friendId);
        }
    }
    public void removeFriend(int friendId) {
        friendIds.remove(Integer.valueOf(friendId));
    }
}
class SocialMediaApp {
    private User head;
    public void addUser(int userId, String name, int age) {
        User user = new User(userId, name, age);
        if (head == null) {
            head = user;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = user;
        }
    }
    public User searchUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public User searchUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public void addFriendConnection(int userId1, int userId2) {
        User user1 = searchUserById(userId1);
        User user2 = searchUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.addFriend(userId2);
            user2.addFriend(userId1);
            System.out.println(user1.name + " and " + user2.name + " are now friends!");
        } else {
            System.out.println("One or both users not found.");
        }
    }
    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = searchUserById(userId1);
        User user2 = searchUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.removeFriend(userId2);
            user2.removeFriend(userId1);
            System.out.println(user1.name + " and " + user2.name + " are no longer friends.");
        } else {
            System.out.println("One or both users not found.");
        }
    }
    public void displayFriends(int userId) {
        User user = searchUserById(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ":");
            for (int friendId : user.friendIds) {
                User friend = searchUserById(friendId);
                if (friend != null) {
                    System.out.println(friend.name + " (ID: " + friend.userId + ")");
                }
            }
        } else {
            System.out.println("User not found.");
        }
    }
    public void findMutualFriends(int userId1, int userId2) {
        User user1 = searchUserById(userId1);
        User user2 = searchUserById(userId2);
        if (user1 != null && user2 != null) {
            Set<Integer> mutualFriends = new HashSet<>(user1.friendIds);
            mutualFriends.retainAll(user2.friendIds);
            System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");
            if (mutualFriends.isEmpty()) {
                System.out.println("No mutual friends found.");
            } else {
                for (int friendId : mutualFriends) {
                    User friend = searchUserById(friendId);
                    if (friend != null) {
                        System.out.println(friend.name + " (ID: " + friend.userId + ")");
                    }
                }
            }
        } else {
            System.out.println("One or both users not found.");
        }
    }
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }
    public void displayUsers() {
        User temp = head;
        System.out.println("List of Users:");
        while (temp != null) {
            System.out.println("User ID: " + temp.userId + " Name: " + temp.name + " Age: " + temp.age);
            temp = temp.next;
        }
    }
}
public class SocialMedia {
    public static void main(String[] args) {
        SocialMediaApp network = new SocialMediaApp();
        network.addUser(1, "Archi", 25);
        network.addUser(2, "Mayank", 27);
        network.addUser(3, "Khushi", 23);
        network.addUser(4, "Krishna", 29);
        network.displayUsers();
        network.addFriendConnection(1, 2);
        network.addFriendConnection(1, 3);
        network.addFriendConnection(2, 4);
        network.displayFriends(1);
        network.displayFriends(2);
        network.findMutualFriends(1, 2);
        network.removeFriendConnection(1, 3);
        network.displayFriends(1);
        network.countFriends();
    }
}
