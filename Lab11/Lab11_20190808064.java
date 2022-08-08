package CSE102LabAssigments;

import java.util.Date;
import java.util.HashSet;

/**
 * @author Ali Çolak
 * 2.03.2021
 */
public class Lab11_20190808064 {

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        User taha = new User(1,"tahayigitalkan","yigitalkan@akdeniz.edu.tr");
        userRepository.add(taha);
        User joseph = new User(2,"josephledet","joseph@akdeniz.edu.tr");
        userRepository.add(joseph);
        System.out.println("Date source size: "+userRepository.count());
        try{
            User melih = new User(2,"melih","melih@akdeniz.edu.tr");
            userRepository.add(melih);
        }catch (Exception e){
            System.out.println("ERROR");
        }

        System.out.println(userRepository.get(1));
        taha.setEmail("tahaalkan@akdeniz.edu.tr");
        userRepository.update(taha);
        System.out.println(userRepository.get(1));

        userRepository.remove(1);
        System.out.println(userRepository.count());

        System.out.println(userRepository.get(1));

        try{
            System.out.println(userRepository.getByEmail("tahaalkan@akdeniz"
                    + ".edu.tr"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
abstract class BaseEntity {
    private int id;
    private Date created;

    public BaseEntity(int id) {
        this.id = id;
        this.created = new Date();
    }

    public int getId() {
        return id;
    }

    public Date getCreated() {
        return created;
    }
}
class User extends BaseEntity {

    private String username;
    private String email;

    public User(int id, String username, String email) {
        super(id);
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", username=" + username + "]";
    }
}
class Role extends BaseEntity {
    private String name;

    public Role(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role [name=" + name + "]";
    }
}
interface IGenericRepository <T extends BaseEntity> {

    void add(T element) ;

    T get (int id);

    void remove (int id) ;

    void update (T element) ;

    int count () ;

}
abstract class GenericRepository<T extends BaseEntity> implements IGenericRepository<T> {
    private HashSet<T> dataSource = new HashSet<>();

    public HashSet<T> getDataSource() {
        return dataSource;
    }
}

interface IUserRepository extends IGenericRepository<User> {

    User getByEmail(String email);

}
class UserRepository extends GenericRepository<User> implements IUserRepository{

    @Override
    public void add(User element) {
        if (getDataSource().contains(element.getId())) {
            throw new RuntimeException();
        }else getDataSource().add(element);
    }

    @Override
    public User get(int id) {
        User user = null;
        for (User i:getDataSource()) {
            if(i.getId()==id){
                user=i;
            }
        }
        if (user== null) {
            throw new RuntimeException();
        }else return user ;
    }

    @Override
    public void remove(int id) {

        int i = 0;

        for (User user:getDataSource()) {
            if(user.getId()==id){
                getDataSource().remove(i);
            }
            i++;
        }

    }

    @Override
    public void update(User element) {
        if (getDataSource().contains(element)) {
            for (User user:getDataSource()) {
                if(user.getId()==element.getId()){
                    user=element;
                }
            }
        } else throw new RuntimeException();
    }

    @Override
    public int count() {
        return getDataSource().size();
    }

    @Override
    public User getByEmail(String email) {
        User user = null;
        for (User i:getDataSource()) {
            if(i.getUsername().equals(email)){
                user=i;
            }
        }
        if (user == null) {
            throw new RuntimeException();
        } else return user ;
    }
}
interface IRoleRepository extends IGenericRepository<Role> {

    Role getByRoleName (String name);

}
class RoleRepository extends GenericRepository<Role> implements IRoleRepository {

    @Override
    public void add(Role element) {
        if (getDataSource().contains(element.getId())) {
            throw new RuntimeException();
        }else getDataSource().add(element);
    }

    @Override
    public Role get(int id) {
        Role role = null;
        for (Role i:getDataSource()) {
            if(i.getId()==id){
                role=i;
            }
        }
        if (role== null) {
            throw new RuntimeException();
        }else return role ;
    }

    @Override
    public void remove(int id) {
        for (Role role:getDataSource()) {
            if(role.getId()==id){
                remove(role.getId());
            }
        }
    }

    @Override
    public void update(Role element) {
        if (getDataSource().contains(element)) {
            for (Role role:getDataSource()) {
                if(role.getId()==element.getId()){
                    role=element;
                }
            }
        } else throw new RuntimeException();
    }

    @Override
    public int count() {
        return getDataSource().size();
    }

    @Override
    public Role getByRoleName(String name) {
        Role role = null;
        for (Role i:getDataSource()) {
            if(i.getName().equals(name)){
                role=i;
            }
        }
        if (name == null) {
            throw new RuntimeException();
        } else return role ;
    }
}