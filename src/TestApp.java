
import ma.projet.bean.Profile;
import ma.projet.bean.Utilisateur;
import ma.projet.service.ProfileService;
import ma.projet.service.UserService;

import java.util.List;

public class TestApp {

    public static void main(String[] args) {

        ProfileService ps = new ProfileService();
        UserService us = new UserService();

        Profile mn = ps.create("MN", "Manager");
        Profile cp = ps.create("CP", "Chef de projet");

        us.create("youssef", "pwd1", mn);
        us.create("fatima", "pwd2", cp);
        us.create("omar", "pwd3", mn);

        System.out.println("Profils :");
        ps.findAll().forEach(System.out::println);

        System.out.println("\nUtilisateurs :");
        us.findAll().forEach(System.out::println);

        mn.setDescription("Manager confirmé");
        ps.update(mn);

        Utilisateur u2 = us.findAll().stream()
                .filter(u -> u.getLogin().equals("fatima"))
                .findFirst()
                .orElse(null);

        if (u2 != null) {
            u2.setPassword("newPwd");
            us.update(u2);
        }

        Utilisateur youssef = us.findAll().stream()
                .filter(u -> u.getLogin().equals("youssef"))
                .findFirst()
                .orElse(null);

        if (youssef != null) {
            us.delete(youssef.getId());
        }

        ps.delete(cp.getId());

        List<Utilisateur> managers = us.findByProfile(mn);
        managers.forEach(System.out::println);
    }
}
