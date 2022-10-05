/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author htmlo
 */
public class Role {
    private int id_Role;
    private String roleName;

    public Role() {
    }

    public Role(int id_Role, String roleName) {
        this.id_Role = id_Role;
        this.roleName = roleName;
    }

    public int getId_Role() {
        return id_Role;
    }

    public void setId_Role(int id_Role) {
        this.id_Role = id_Role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" + "id_Role=" + id_Role + ", roleName=" + roleName + '}';
    }
    
    
    
}
