package fsmprototype;

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import javax.xml.transform.OutputKeys;

/**
 *
 * @author Alvin Lu
 */
public class Game_Saver {
    
    private static Element createObject(Document doc,  Object o)
    {
        Element object = doc.createElement("Object");
        Attr o_type = doc.createAttribute("type");
        o_type.setValue(o.getClass().getName().substring(13));
        object.setAttributeNode(o_type);

        Attr o_name = doc.createAttribute("name");
        o_name.setValue(o.getName());
        object.setAttributeNode(o_name);
        
        if(o instanceof Container){
            Container cont = (Container)o;
            for(Object c:cont.getObjects()){
                Element cont_obj = createObject(doc, c);
                object.appendChild(cont_obj);
            }
        }
        
        else if(o instanceof Player){
            Player ply = (Player) o;
            for(Object p: ply.getItems()){
                Element ply_obj = createObject(doc, p);
                object.appendChild(ply_obj);
            }
        }
        return object;
    }
    
    public static void saveFile(ArrayList<Room> room){
        try{
            DocumentBuilderFactory dbFactory =
            DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            
            Element asl = doc.createElement("asl");
            Attr version = doc.createAttribute("version");
            version.setValue("1.0");
            doc.appendChild(asl);
            
            Element game = doc.createElement("game");
            asl.appendChild(game);
            
            Element id = doc.createElement("id");
            game.appendChild(id);
            
            Element g_version = doc.createElement("version");
            game.appendChild(g_version);
            
            Element rooms;
            Attr r_type;
            Attr r_name;
            
            for(Room r: room){
                rooms = doc.createElement("Object");
                r_type = doc.createAttribute("type");
                r_type.setValue("Room");
                
                r_name = doc.createAttribute("name");
                r_name.setValue(r.getName());
                
                rooms.setAttributeNode(r_type);
                rooms.setAttributeNode(r_name);
                
                LinkedList exits = r.getExit();
                for(int i = 0; i < exits.size(); i++){
                    Exit e = (Exit) exits.get(i);
                    Element exit = doc.createElement("Exits");
                    Attr exit_alias = doc.createAttribute("alias");
                    exit_alias.setValue(e.getName());
                    Attr exit_to = doc.createAttribute("to");
                    exit_to.setValue(e.takeExit().getName());
                    exit.setAttributeNode(exit_alias);
                    exit.setAttributeNode(exit_to);
                    rooms.appendChild(exit);
                }
                
                for(Object o: r.getObject()){
                    Element object = createObject(doc, o);
                    rooms.appendChild(object);
                }
                asl.appendChild(rooms);
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\Alvin Lu\\Desktop\\3rd Year Project\\test.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void save_Created_Game(Game g, String direct){
        try {
            FileOutputStream fileOut =
            new FileOutputStream(direct);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(g);
            out.close();
            fileOut.close();
         } catch (IOException i) {
            i.printStackTrace();
         }
    }
    
    public static Game load_Created_Game(String direct){
        Game g = null;
        try {
            FileInputStream fileIn = new FileInputStream(direct);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            g = (Game) in.readObject();
            in.close();
            fileIn.close();
         } catch (IOException i) {
            i.printStackTrace();
            return null;
         } catch (ClassNotFoundException c) {
            System.out.println("Not found");
            c.printStackTrace();
            return null;
         }
        
        for(Room r:g.getRooms()){
            System.out.println(r.getName());
            for(Object o:r.getObject()){
                System.out.printf("   > ");
                System.out.println(o.getName());
                if(o instanceof Container){
                    Container cont = (Container)o;
                    for(Object c:cont.getObjects()){
                        System.out.printf("       > ");
                        System.out.println(c.getName());
                    }
                }
                else if(o instanceof Player || o instanceof Human){
                    Player ply = (Player) o;
                    for(Object p: ply.getItems()){
                        System.out.printf("       > ");
                        System.out.println(p.getName());
                    }
                }
            }
        }
        return g;
    }
    
    public static void main(String[] args) {
        ArrayList<Object> o = new ArrayList();
        LinkedList<Exit> e = new LinkedList();
        ArrayList<Room> r = new ArrayList();
        
        
        Pick_Able_Object o1 = new Pick_Able_Object("Rock");
        Edible o2 = new Edible("Bread");
        Unlimited_Use_Object o3 = new Unlimited_Use_Object("Mirror");
        
        Pick_Able_Object o4 = new Pick_Able_Object("Phone");
        Pick_Able_Object o5 = new Pick_Able_Object("Wallet");
        
        Room r1 = new Room("Living Room");
        Room r2 = new Room("Garden");
        
        Player p = new Player("Player", r1);
        p.pickup(o4);
        p.pickup(o5);
        
        r1.addObject(p);
        r1.addObject(o3);
        r1.addExit("North", r2);
        
        r2.addObject(o2);
        r2.addObject(o1);
        r2.addExit("South", r1);
        
        r.add(r1);
        r.add(r2);
        
        Game g = new Game(r,p);
        save_Created_Game(g, "C:\\Users\\Alvin Lu\\Desktop\\3rd Year Project\\test.ser");
        load_Created_Game("C:\\Users\\Alvin Lu\\Desktop\\3rd Year Project\\test.ser");
        //saveFile(r);
    }
}
