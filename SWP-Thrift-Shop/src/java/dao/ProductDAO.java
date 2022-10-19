/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Product;

public class ProductDAO {

    public List<Product> listAll() {
        List<Product> list = null;
        DBUtil db = new DBUtil();
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT TOP(18) Product.Id,ProductName,"
                    + "ProductPrice,ImageLink\n"
                    + "FROM Product left join [Image] \n"
                    + "ON Product.Id = [Image].ProductID \n"
                    + "ORDER BY Product.ProductName DESC");
            while (rs.next()) {
                int productID = rs.getInt(1);
                String productName = rs.getString(2);
                int productPrice = rs.getInt(3);
                String imageLink = rs.getString(4);
                Product pro = new Product(productID, productName,
                        productPrice, imageLink);
                list.add(pro);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> listNew() {
        List<Product> list = null;
        DBUtil db = new DBUtil();
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT TOP(6) Product.Id,"
                    + "ProductName,ProductPrice, ImageLink\n"
                    + "FROM Product left join [Image]\n"
                    + "ON Product.Id = [Image].ProductID\n"
                    + "ORDER BY Product.Id DESC");
            while (rs.next()) {
                int productID = rs.getInt(1);
                String productName = rs.getString(2);
                int productPrice = rs.getInt(3);
                String imageLink = rs.getString(4);
                Product pro = new Product(productID, productName,
                        productPrice, imageLink);
                list.add(pro);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getProductByCID(String categoryID) {
        List<Product> list = null;
        DBUtil db = new DBUtil();
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            String sql = "SELECT Product.Id,ProductName,"
                    + "ProductPrice, ImageLink, CategoryID\n"
                    + "FROM Product left join [Image]\n"
                    + "ON Product.Id = [Image].ProductID \n"
                    + "WHERE CategoryID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, categoryID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt(1);
                String productName = rs.getString(2);
                int productPrice = rs.getInt(3);
                String imageLink = rs.getString(4);
                Product pro = new Product(productID, productName,
                        productPrice, imageLink);
                list.add(pro);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int countProductByCID(String categoryID) {
        DBUtil db = new DBUtil();
        int num = 0;
        String query = "SELECT COUNT(Id)\n"
                + "FROM Product\n"
                + "WHERE CategoryID = ?";
        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, categoryID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                num = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    public Product getProductbyID(String pid) {
        DBUtil db = new DBUtil();
        String query = "SELECT ProductID,ProductName,ProductPrice,ProductQuantity, \n"
                + "ProductDesc,Rating, ImageLink\n"
                + "FROM dbo.Product left join [Image]\n"
                + "ON Product.Id = [Image].ProductID\n"
                + "WHERE ProductID= ?";
        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getInt(4), rs.getString(5), rs.getFloat(6), rs.getString(7));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getRelatedProduct(String categoryID) {
        List<Product> list = null;
        DBUtil db = new DBUtil();
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            String sql = "SELECT TOP(6) Product.Id,ProductName,"
                    + "ProductPrice, ImageLink, CategoryID\n"
                    + "FROM Product left join [Image]\n"
                    + "ON Product.Id = [Image].ProductID \n"
                    + "WHERE CategoryID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, categoryID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt(1);
                String productName = rs.getString(2);
                int productPrice = rs.getInt(3);
                String imageLink = rs.getString(4);
                Product pro = new Product(productID, productName,
                        productPrice, imageLink);
                list.add(pro);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
   
    public static void main(String[] args) {
        ProductDAO pd = new ProductDAO();
        List<Product> list = pd.getRelatedProduct("1");
        for (Product product : list) {
            System.out.println(product);
        }
    }

    public List<Product> listHome() {
        List<Product> list = null;
        DBUtil db = new DBUtil();
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT Product.Id, ProductPrice,ProductName,ImageLink\n"
                    + "FROM Product left join [Image]\n"
                    + "ON Product.Id = [Image].ProductID\n"
                    + "ORDER BY ProductName ASC\n"
                    + "OFFSET 0 ROWS FETCH NEXT 6 ROWs ONLY");
            while (rs.next()) {
                int productID = rs.getInt(1);
                int productPrice = rs.getInt(2);
                String productName = rs.getString(3);
                String imageLink = rs.getString(4);
                Product pro = new Product(productID, productName, productPrice, imageLink);
                list.add(pro);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int minPrice() {
        int price = 0;
        DBUtil db = new DBUtil();
        try {
            Connection con = db.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT MIN(ProductPrice) FROM dbo.Product");
            while (rs.next()) {
                price = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return price;
    }

    public int maxPrice() {
        int price = 0;
        DBUtil db = new DBUtil();
        try {
            Connection con = db.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT MAX( ProductPrice) FROM dbo.Product");
            while (rs.next()) {
                price = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return price;
    }
//    public List<Product> filter(String genreID, String consolesID, int minPrice, int maxPrice, String rating) {
//        List<Product> list = null;
//        DBUtil db = new DBUtil();
//        String genreCondition = " ";
//        String consolesCondition = " ";
//        String ratingCondition = " ";
//
//        if (genreID != null) {
//            genreCondition = " genreID = " + genreID + " and ";
//        }
//        if (consolesID != null) {
//            consolesCondition = " consolesID = " + consolesID + " and ";
//        }
//        if (rating != null) {
//            ratingCondition = " rating = " + rating + " and ";
//        }
//        try {
//            list = new ArrayList<>();
//            Connection con = db.getConnection();
//            PreparedStatement pstm = con.prepareStatement("SELECT ProductID, ProductPrice,ProductName,LinkIMG1\n"
//                    + "FROM dbo.Product \n"
//                    + "Where" + genreCondition + consolesCondition + ratingCondition + "ProductPrice >= ? AND ProductPrice <= ?");
//            pstm.setInt(1, minPrice);
//            pstm.setInt(2, maxPrice);
//            ResultSet rs = pstm.executeQuery();
//            while (rs.next()) {
//                int productID = rs.getInt(1);
//                int price = rs.getInt(2);
//                String productName = rs.getString(3);
//                String linkImg1 = rs.getString(4);
//                Product pro = new Product(productID, price, productName, linkImg1);
//                list.add(pro);
//            }
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//

    public List<Product> findProductByName(String fname) {
        List<Product> list = null;
        DBUtil db = new DBUtil();
        if (fname == null) {
            fname = "";
        }
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT Product.Id, ProductPrice,ProductName,ImageLink\n"
                    + "FROM dbo.Product left join [Image]\n"
                    + "ON Product.Id = [Image].ProductID\n"
                    + "WHERE ProductName LIKE ?");
            pstm.setString(1, "%" + fname + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt(1);
                int productPrice = rs.getInt(2);
                String productName = rs.getString(3);
                String imageLink = rs.getString(4);
                Product pro = new Product(productID, productName, productPrice, imageLink);
                list.add(pro);
            }
            con.close();
        } catch (Exception e) {
        }
        return list;
    }

//    public static void main(String[] args) {
//        ProductDAO dao = new ProductDAO();
//        List<Product> list = new ArrayList();
//        Product pro = new Product();
//        pro = dao.getProductbyID("2");
//        for (Product product : list) {
//            System.out.println(product);
//        }
//        System.out.println(pro);
//    }
//    public List<Product> listFull() {
//        List<Product> list = null;
//        DBUtil db = new DBUtil();
//
//        try {
//            list = new ArrayList<>();
//            Connection con = db.getConnection();
//            Statement stm = con.createStatement();
//            ResultSet rs = stm.executeQuery("SELECT ProductID,ProductPrice,ProductName,\n"
//                    + "	   ProductQuantity,ProductDesc,Rating,LinkIMG1,\n"
//                    + "       LinkIMG2,LinkIMG3,LinkIMG4,LinkIMG5,\n"
//                    + "	   Product.GenreID,GenreName,Product.ConsolesID,ConsolesName \n"
//                    + "FROM dbo.Product LEFT JOIN dbo.Genre  \n"
//                    + "ON Genre.GenreID = Product.GenreID \n"
//                    + "LEFT JOIN dbo.Consoles \n"
//                    + "ON Consoles.ConsolesID = Product.ConsolesID\n");
//            while (rs.next()) {
//                int productID = rs.getInt(1);
//                int price = rs.getInt(2);
//                String productName = rs.getString(3);
//                byte quantity = rs.getByte(4);
//                String desc = rs.getString(5);
//                byte rating = rs.getByte(6);
//                String linkImg1 = rs.getString(7);
//                String linkImg2 = rs.getString(8);
//                String linkImg3 = rs.getString(9);
//                String linkImg4 = rs.getString(10);
//                String linkImg5 = rs.getString(11);
//                int genreID = rs.getInt(12);
//                String genreName = rs.getString(13);
//                int consolesID = rs.getInt(14);
//                String consolesName = rs.getString(15);
//                Genre genre = new Genre(genreID, genreName);
//                Consoles console = new Consoles(consolesID, consolesName);
//                Product pro = new Product(productID, price, productName, quantity, desc, rating, linkImg1, linkImg2, linkImg3, linkImg4, linkImg5, genre, console);
//                list.add(pro);
//            }
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public boolean updateProduct(int productID, int price, String productName,
//            byte quantity, String desc, byte rating, String linkImg1,
//            String linkImg2, String linkImg3, String linkImg4,
//            String linkImg5, int genreID, int consolesID) throws SQLException, Exception {
//        DBUtil db = new DBUtil();
//        Connection con = db.getConnection();
//        String sql = "UPDATE dbo.Product\n"
//                + "SET ProductPrice = ?,ProductName =?, ProductQuantity=?,ProductDesc=?,\n"
//                + "Rating=?,LinkIMG1=?,LinkIMG2=?,LinkIMG3=?,LinkIMG4=?,LinkIMG5=?,GenreID=?,ConsolesID=?\n"
//                + "WHERE ProductID=?";
//        PreparedStatement stm = con.prepareStatement(sql);
//        stm.setInt(1, price);
//        stm.setString(2, productName);
//        stm.setByte(3, quantity);
//        stm.setString(4, desc);
//        stm.setByte(5, rating);
//        stm.setString(6, linkImg1);
//        stm.setString(7, linkImg2);
//        stm.setString(8, linkImg3);
//        stm.setString(9, linkImg4);
//        stm.setString(10, linkImg5);
//        stm.setInt(11, genreID);
//        stm.setInt(12, consolesID);
//        stm.setInt(13, productID);
//        int count = stm.executeUpdate();
//        return count == 1;
//    }
//
//    public boolean delete(int productID) throws SQLException, Exception {
//        DBUtil db = new DBUtil();
//        Connection con = db.getConnection();
//        String sql = "DELETE FROM dbo.Product WHERE ProductID = ?";
//        PreparedStatement stm = con.prepareStatement(sql);
//        stm.setInt(1, productID);
//        int count = stm.executeUpdate();
//        return count == 1;
//    }
//
//    public boolean createProduct( int price, String productName,
//            byte quantity, String desc, byte rating, String linkImg1,
//            String linkImg2, String linkImg3, String linkImg4,
//            String linkImg5, int genreID, int consolesID) throws SQLException, Exception {
//        DBUtil db = new DBUtil();
//        Connection con = db.getConnection();
//        String sql = "insert into dbo.Product values(?,?,?,?,?,?,?,?,?,?,?,?)";
//        PreparedStatement stm = con.prepareStatement(sql);
//        stm.setInt(1, price);
//        stm.setString(2, productName);
//        stm.setByte(3, quantity);
//        stm.setString(4, desc);
//        stm.setByte(5, rating);
//        stm.setString(6, linkImg1);
//        stm.setString(7, linkImg2);
//        stm.setString(8, linkImg3);
//        stm.setString(9, linkImg4);
//        stm.setString(10, linkImg5);
//        stm.setInt(11, genreID);
//        stm.setInt(12, consolesID);
//        int count = stm.executeUpdate();
//        return count == 1;
//    }
//
//    public List<Product> listByID(int id) {
//        List<Product> list = null;
//        DBUtil db = new DBUtil();
//        try {
//            list = new ArrayList<>();
//            Connection con = db.getConnection();
//            String sql = "SELECT ProductID,ProductPrice,ProductName,\n"
//                    + "	   ProductQuantity,ProductDesc,Rating,LinkIMG1,\n"
//                    + "       LinkIMG2,LinkIMG3,LinkIMG4,LinkIMG5,\n"
//                    + "	   Product.GenreID,GenreName,Product.ConsolesID,ConsolesName \n"
//                    + "FROM dbo.Product LEFT JOIN dbo.Genre  \n"
//                    + "ON Genre.GenreID = Product.GenreID \n"
//                    + "LEFT JOIN dbo.Consoles \n"
//                    + "ON Consoles.ConsolesID = Product.ConsolesID\n"
//                    + "Where productID = ?";
//            PreparedStatement stm = con.prepareStatement(sql);
//            stm.setInt(1, id);
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                int productID = rs.getInt(1);
//                int price = rs.getInt(2);
//                String productName = rs.getString(3);
//                byte quantity = rs.getByte(4);
//                String desc = rs.getString(5);
//                byte rating = rs.getByte(6);
//                String linkImg1 = rs.getString(7);
//                String linkImg2 = rs.getString(8);
//                String linkImg3 = rs.getString(9);
//                String linkImg4 = rs.getString(10);
//                String linkImg5 = rs.getString(11);
//                int genreID = rs.getInt(12);
//                String genreName = rs.getString(13);
//                int consolesID = rs.getInt(14);
//                String consolesName = rs.getString(15);
//                Genre genre = new Genre(genreID, genreName);
//                Consoles console = new Consoles(consolesID, consolesName);
//                Product pro = new Product(productID, price, productName, quantity, desc, rating, linkImg1, linkImg2, linkImg3, linkImg4, linkImg5, genre, console);
//                list.add(pro);
//            }
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<Product> listByName(String name) {
//        List<Product> list = null;
//        DBUtil db = new DBUtil();
//        try {
//            list = new ArrayList<>();
//            Connection con = db.getConnection();
//            String sql = "SELECT ProductID,ProductPrice,ProductName,\n"
//                    + "	   ProductQuantity,ProductDesc,Rating,LinkIMG1,\n"
//                    + "       LinkIMG2,LinkIMG3,LinkIMG4,LinkIMG5,\n"
//                    + "	   Product.GenreID,GenreName,Product.ConsolesID,ConsolesName \n"
//                    + "FROM dbo.Product LEFT JOIN dbo.Genre  \n"
//                    + "ON Genre.GenreID = Product.GenreID \n"
//                    + "LEFT JOIN dbo.Consoles \n"
//                    + "ON Consoles.ConsolesID = Product.ConsolesID\n"
//                    + "Where productName like ?";
//            PreparedStatement stm = con.prepareStatement(sql);
//            stm.setString(1, "%" + name + "%");
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                int productID = rs.getInt(1);
//                int price = rs.getInt(2);
//                String productName = rs.getString(3);
//                byte quantity = rs.getByte(4);
//                String desc = rs.getString(5);
//                byte rating = rs.getByte(6);
//                String linkImg1 = rs.getString(7);
//                String linkImg2 = rs.getString(8);
//                String linkImg3 = rs.getString(9);
//                String linkImg4 = rs.getString(10);
//                String linkImg5 = rs.getString(11);
//                int genreID = rs.getInt(12);
//                String genreName = rs.getString(13);
//                int consolesID = rs.getInt(14);
//                String consolesName = rs.getString(15);
//                Genre genre = new Genre(genreID, genreName);
//                Consoles console = new Consoles(consolesID, consolesName);
//                Product pro = new Product(productID, price, productName, quantity, desc, rating, linkImg1, linkImg2, linkImg3, linkImg4, linkImg5, genre, console);
//                list.add(pro);
//            }
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<Product> findProductByGenreID(int id) {
//        List<Product> list = null;
//        DBUtil db = new DBUtil();
//        try {
//            list = new ArrayList<>();
//            Connection con = db.getConnection();
//            PreparedStatement pstm = con.prepareStatement("SELECT ProductID, ProductPrice,ProductName,LinkIMG1\n"
//                    + "FROM dbo.Product \n"
//                    + "Where genreID = ?");
//            pstm.setInt(1, id);
//            ResultSet rs = pstm.executeQuery();
//            while (rs.next()) {
//                int productID = rs.getInt(1);
//                int price = rs.getInt(2);
//                String productName = rs.getString(3);
//                String linkImg1 = rs.getString(4);
//                Product pro = new Product(productID, price, productName, linkImg1);
//                list.add(pro);
//            }
//            con.close();
//        } catch (Exception e) {
//        }
//        return list;
//    }
}
