package fsmprototype;

import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.CollapsedDependenciesAnnotation;
import edu.stanford.nlp.trees.TypedDependency;
import edu.stanford.nlp.util.CoreMap;
import static fsmprototype.Main_Edit.g;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author Alvin Lu
 */
public class Play_Game extends javax.swing.JFrame {

    protected Game game;
    StanfordCoreNLP pipeline;
    ArrayList<String> movement;
    ArrayList<String> observe;
    ArrayList<String> takeItem;
    ArrayList<String> dropItem;
    
    public Play_Game() {
        game = (Game) deepClone(Main_Edit.g);
        initComponents();
        setLocationRelativeTo(null);
        JOptionPane.showMessageDialog(jScrollPane1,
                "Currently creating your game!");
        
        movement = new ArrayList();
        observe = new ArrayList();
        takeItem = new ArrayList();
        dropItem = new ArrayList();
        initWordList();
        
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, parse");
        pipeline = new StanfordCoreNLP(props);
        if(game != null){
            Gameplay.append("Welcome " + game.getPlayer().getName() + "\n");
            if(game.getPlayer().getDesc() != null){
                Gameplay.append(game.getPlayer().getDesc()+ "\n");
            }
            roomChange();
        }
        else{
            Gameplay
                    .append("Your game is currently empty!"
                            + " Please insert a player and room!");
        }
    }
    
    /**
     * Initiate the list of words
     */
    private void initWordList(){
        movement.add("go");
        movement.add("run");
        movement.add("procceed");
        movement.add("move");
        movement.add("walk");
        
        observe.add("look");
        observe.add("observe");
        observe.add("inspect");
        
        takeItem.add("take");
        takeItem.add("grab");
        takeItem.add("obtain");
        
        dropItem.add("drop");
        dropItem.add("throw");
        dropItem.add("remove");
    }
    
    /**
     * Provides a deep clone of an object
     * @param object object to be deep cloned
     * @return deep cloned object
     */
    public static java.lang.Object deepClone(java.lang.Object object) {
        try {
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          ObjectOutputStream oos = new ObjectOutputStream(baos);
          oos.writeObject(object);
          ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
          ObjectInputStream ois = new ObjectInputStream(bais);
          return ois.readObject();
        }
        catch (Exception e) {
          e.printStackTrace();
          return null;
        }
    }
    
    /**
     * Initiates a room change and append new room's information
     */
    private void roomChange(){
        Gameplay.append("---------------------------------------------------\n");
        Gameplay.append("You are currently at: " + game.getPlayer().getLocation() + "\n");
        Gameplay.append("You can see... ");
        for(Object o: game.getPlayer().getLocation().getObject()){
            Gameplay.append(o.getName() + " ");
        }
        Gameplay.append("\n");
        Gameplay.append("You can go...");
        for(Exit e: game.getPlayer().getLocation().getExit()){
            Gameplay.append(e.getName() + " ");
        }
        Gameplay.append("\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Command = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Gameplay = new javax.swing.JTextArea();
        Information = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventory = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        player_att = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        save_game = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Command.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        Command.setText("Enter command");
        Command.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommandActionPerformed(evt);
            }
        });

        Gameplay.setColumns(20);
        Gameplay.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        Gameplay.setEditable(false);
        Gameplay.setRows(5);
        Gameplay.setLineWrap(true);
        jScrollPane2.setViewportView(Gameplay);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1239, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Player info");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Inventory");

        updateTree();
        inventory.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jScrollPane1.setViewportView(inventory);

        player_att.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        player_att.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        player_att.setRowHeight(24);
        jScrollPane3.setViewportView(player_att);
        updatePlayerAttribute();

        javax.swing.GroupLayout InformationLayout = new javax.swing.GroupLayout(Information);
        Information.setLayout(InformationLayout);
        InformationLayout.setHorizontalGroup(
            InformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(InformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );
        InformationLayout.setVerticalGroup(
            InformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setText("Play Game");

        save_game.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        save_game.setText("Save game");
        save_game.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_gameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Command)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Information, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(save_game)
                                .addGap(104, 104, 104))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(save_game)
                        .addGap(2, 2, 2)
                        .addComponent(Information, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Command, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommandActionPerformed
        String text = Command.getText();
        Command.setText("   ");
        Gameplay.append(text + "\n");
        Annotation document = new Annotation(text);
        pipeline.annotate(document);
        
        List<CoreMap> sentences = document.get(SentencesAnnotation.class);

        List<String> words = new ArrayList<>();
        List<String> posTags = new ArrayList<>();
        List<String> nerTags = new ArrayList<>();
        for (CoreMap sentence : sentences) {
            // traversing the words in the current sentence
            for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
                // this is the text of the token
                String word = token.get(TextAnnotation.class);
                words.add(word);
                // this is the POS tag of the token
                String pos = token.get(PartOfSpeechAnnotation.class);
                posTags.add(pos);
                // this is the NER label of the token
                String ne = token.get(NamedEntityTagAnnotation.class);
                nerTags.add(ne);
            }
            SemanticGraph dependencies = sentence.get(CollapsedDependenciesAnnotation.class);
            ArrayList<TypedDependency> dep = (ArrayList)dependencies.typedDependencies();
            processSentence(dep);
        }
    }//GEN-LAST:event_CommandActionPerformed

    private void save_gameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_gameActionPerformed
        JFileChooser saveFile = new JFileChooser();
        int returnVal = saveFile.showSaveDialog(jPanel1);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            String name = saveFile.getSelectedFile().toString();
            name = name + ".ser";
            Game_Saver.save_Created_Game(g, name);
        }
        else if(returnVal == JFileChooser.CANCEL_OPTION){
            saveFile.cancelSelection();
        }
    }//GEN-LAST:event_save_gameActionPerformed

    /**
     * Given the dependency triple find the verb and subject
     * @param d List of dependency triple from the sentence
     */
    private void processSentence(ArrayList<TypedDependency> d){
        String rel, gov, dep;
        Boolean commandFound = false;
        for(int i = 0; i < d.size(); i++){
            rel = d.get(i).reln().toString();
            gov = d.get(i).gov().word();
            dep = d.get(i).dep().word();
            
            if(dep.equals("help") && rel.equals("root")){
               helpFeature();
               commandFound = true;
            }
            
            if(isMovement(rel, gov, dep)){
                commandFound = true;
                int count = 0;
                Room r = null;
                String result = findAdjectiveSubject(d);
                if(result != null){
                   while(count < game.getRooms().size() && r == null){
                        if(game.getRooms().get(count).findExit(result) != null){
                            r = game.getRooms().get(count);
                        }
                        count++;
                    } 
                }
                else{
                    while(count < game.getRooms().size() && r == null){
                        if(game.getRooms().get(count).findExit(dep) != null){
                            r = game.getRooms().get(count);
                        }
                        count++;
                    }
                }
                if(r != null){
                    if(!r.getCurrentState().allowAccess()){
                        Gameplay.append("Can't enter room! State "+ 
                                r.getCurrentState().getName() + 
                                " doesn't allow movement\n");
                    }
                    else{
                       if(result != null){
                            if(game.getPlayer().move(result) == null){
                                Gameplay.append("No such direction!\n");
                            }
                            else{
                                roomChange();
                            }
                       }
                       else{
                            if(game.getPlayer().move(dep) == null){
                                Gameplay.append("No such direction!\n");
                            }
                            else{
                                roomChange();
                            } 
                       }
                    }
                }
                else{
                    Gameplay.append("No such direction found!\n");
                }
            }
            else if(isMovement_dep(rel, gov, dep)){
                commandFound = true;
                int count = 0;
                String result = findAdjectiveSubject(d);
                Room r = null;
                if(result != null){
                   while(count < game.getRooms().size() && r == null){
                        if(game.getRooms().get(count).findExit(result) != null){
                            r = game.getRooms().get(count);
                        }
                        count++;
                    } 
                }
                else{
                    while(count < game.getRooms().size() && r == null){
                        if(game.getRooms().get(count).findExit(gov) != null){
                            r = game.getRooms().get(i);
                        }
                        count++;
                    }
                }
                if(r != null){
                    if(!r.getCurrentState().allowAccess()){
                        Gameplay.append("Can't enter room! State "+ 
                                r.getCurrentState().getName() + 
                                " doesn't allow movement\n");
                    }
                    else{
                        if(result != null){
                            if(game.getPlayer().move(result) == null){
                                Gameplay.append("No such direction!\n");
                            }
                            else{
                                roomChange();
                            }
                        }
                        else{
                            if(game.getPlayer().move(gov) == null){
                            Gameplay.append("No such direction!\n");
                            }
                            else{
                                roomChange();
                            } 
                        }
                    }
                }
                else{
                    Gameplay.append("No such direction found!\n");
                }
            }
            else if(isObserving(rel, gov, dep)){
                Gameplay.append(game.findObjectInRoomByName(dep).getDesc());
                Object obj = game.findObjectInRoomByName(dep);
                ArrayList<Verb> verbs = obj.getVerbs();
                if(verbs.isEmpty()){
                    Gameplay.append("No action can be done");
                }
                else{
                    Gameplay.append("You can: ");
                    for(Verb v:verbs){
                        Gameplay.append(v.getName() +" " +
                                v.getAssociatedObject() 
                            + ", ");
                    }     
                }
                Gameplay.append("\n");
                if(obj instanceof Container){
                    if(obj.getCurrentState() == null){
                        Gameplay.append("It contains: ");
                        for(Object items: ((Container) obj).getObjects()){
                            Gameplay.append(items.getName());
                        }
                        Gameplay.append("\n");
                    }
                    else if(((Container)obj).getCurrentState().allowAccess()){
                        Gameplay.append("It contains: ");
                        for(Object items: ((Container) obj).getObjects()){
                            Gameplay.append(items.getName());
                        }
                        Gameplay.append("\n");
                    }
                    else{
                        Gameplay.append("You can't see inside the box \n");
                        Gameplay.append("It's " + 
                                obj.getCurrentState().getName() + "\n");
                    }
                    
                }
                else if(obj instanceof Player){
                    Gameplay.append("It contains: ");
                    for(Object items: ((Player) obj).getItems()){
                        Gameplay.append(items.getName());
                    }
                }
                Gameplay.append("\n");
                commandFound = true;
            }
            else if(isTaking(rel, gov, dep)){
                Object o = game.findObjectInRoomByName(dep);
                if(o != null){
                    if(o instanceof Pick_Able_Object){
                        game.givePlayer(o);
                        Gameplay.append("Taken " + o.getName() + "\n");
                        updateTree();
                    }
                    else{
                        Gameplay.append(o.getName() + " can't be picked up\n");
                    }
                }
                else{
                    Gameplay.append("No such object!\n");
                }
                commandFound = true;
            }
            else if(isDropping(rel, gov, dep)){
                Object o = game.getPlayer().drop(dep);
                if(o != null){
                    game.addObjectToCurrentRoom(o);
                    Gameplay.append("Dropped " + o.getName() + "\n");
                    updateTree();
                }
                else{
                    Gameplay.append("No such object!\n");
                }
                commandFound = true;
            }
            else if(isDropping_dep(rel, gov, dep)){
                Object o = game.getPlayer().drop(gov);
                if(o != null){
                    Gameplay.append("Dropped " + o.getName() + "\n");
                    game.addObjectToCurrentRoom(o);
                    updateTree();
                }
                else{
                    Gameplay.append("No such object!\n");
                }
                commandFound = true;
            }
            else if(isAction(rel, gov, dep)){
                commandFound = processVerbs(rel, gov, dep);
                
            }
        }
        if(!commandFound){
            Gameplay.append("Command not recognised!\n");
        }
    }
    
    /**
     * Outputs the generic help instructions
     */
    private void helpFeature(){
        Gameplay.append("Move around by entering 'go' followed "
                + "by the location \n");
        Gameplay.append("Look at objects by entering 'look' "
                + "followed by the object\n");
        Gameplay.append("Interact with different objects with "
                + "their specific verbs, enter 'look' to learn what you "
                + "can do with them!\n");
    }
    
    /**
     * Given the list of dependencies, find a subject that contains an adjective
     * @param d dependency triples
     * @return 
     */
    private String findAdjectiveSubject(ArrayList<TypedDependency> d)
    {
        String rel, gov, dep, result;
        for(int i = 0; i < d.size(); i++){
            rel = d.get(i).reln().toString();
            gov = d.get(i).gov().word();
            dep = d.get(i).dep().word();
            if(rel.contains("amod")){
                result = dep + " " + gov;
                return result;
            }
        }
        return null;
    }
    /**
     * Checks if the verb is related to movement
     * @param rel relationship between the words
     * @param gov government word 
     * @param dep dependent word
     * @return true if the verb is regarding to movement
     */
    private boolean isMovement(String rel, String gov, String dep){
        if(rel.contains("advmod") || rel.contains("nmod:to")){
            if(movement.contains(gov)){
                return true;
            }
        }
        else if(rel.contains("dobj")){
            if(movement.contains(gov)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Check if the dependent word is movement
     * @param rel relationship between two words
     * @param gov government word
     * @param dep dependent word
     * @return true if the verb is movement
     */
    private boolean isMovement_dep(String rel, String gov, String dep){
        if(rel.contains("nsubj") || rel.contains("nmod:to") || rel.contains("nmod")){
            if(movement.contains(dep)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Check if the word is observing word
     * @param rel relationship between two words
     * @param gov government word
     * @param dep dependent word
     * @return true if the verb is observing word
     */
    private boolean isObserving(String rel, String gov, String dep){
        if(rel.contains("nmod:at")){
            if(observe.contains(gov)){
                return true;
            }
        }
        else if(rel.contains("dobj")){
            if(observe.contains(gov)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Check if the word is taking word
     * @param rel relationship between two words
     * @param gov government word
     * @param dep dependent word
     * @return true if the verb is taking word
     */
    private boolean isTaking(String rel, String gov, String dep){
        if(rel.contains("dobj")){
            if(takeItem.contains(gov)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Check if the word is dropping word
     * @param rel relationship between two words
     * @param gov government word
     * @param dep dependent word
     * @return true if the verb is dropping word
     */
    private boolean isDropping(String rel, String gov, String dep){
        if(rel.contains("dobj")){
            if(dropItem.contains(gov)){
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Check if the dependent word is dropping word
     * @param rel relationship between two words
     * @param gov government word
     * @param dep dependent word
     * @return true if the verb is observing word 
     */
    private boolean isDropping_dep(String rel, String gov, String dep){
        if(rel.contains("compound")){
            if(dropItem.contains(dep)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Check if the dependent word is an action word
     * @param rel relationship between two words
     * @param gov government word
     * @param dep dependent word
     * @return true if the verb is observing word
     */
    private boolean isAction(String rel, String gov, String dep){
        if(rel.contains("dobj") || rel.contains("nmod:npmod") || 
                rel.contains("nmod:on")){
            return true;
        }
        return false;
    }    
    
    /**
     * Process the verbs
     * @param rel relationship
     * @param gov government word
     * @param dep dependent word
     */
    private boolean processVerbs(String rel, String gov, String dep){
        Object o = game.findAssociatedObjinVerb(gov, dep);
        boolean done = false;
        if(o != null){
            Attribute att = game.findAttByAssociatedObject(gov, o);
            if(att == null){
                if(!o.sendAction(gov)){
                    boolean found = false;
                    for(Transition t: o.getCurrentState().getTransition()){
                        if(t.getAction().equalsIgnoreCase(gov)){
                            conditionNotMet(t);
                            found = true;
                        }
                    }
                    if(!found){
                        JLabel label = new JLabel("Object not found!");
                        label.setFont(new Font("Tahoma", Font.PLAIN, 24));
                        JOptionPane.showMessageDialog(jPanel1, 
                            label, 
                            "Object not found", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    Gameplay.append(o.getName() + "'s current state is: " 
                            + o.getCurrentState().getName() + "\n");
                }
            }
            else if(att.inRoom()){
                Verb v = att.getVerb();
                if(game.findObjectInRoomByName(att.getVerb()
                        .getAssociatedObject()
                        .getName()) != null){
                    if(o instanceof Limited_Use_Object){
                        if(((Limited_Use_Object) o).use()){
                            att.modify(v.getEffect());
                            done = true;
                        }
                        else{
                            Gameplay.append(o.getName() + " out of uses\n");
                        }
                    }
                    else{
                       att.modify(v.getEffect()); 
                       done = true;
                    } 
                }
                else{
                    Gameplay.append(att.getVerb().getAssociatedObject()
                            .getName() + " cannot be used here!\n"); 
                }
            }
            else{
                Verb v = att.getVerb();
                if(o instanceof Limited_Use_Object){
                        if(((Limited_Use_Object) o).use()){
                            att.modify(v.getEffect());
                            done = true;
                        }
                        else{
                            Gameplay.append(o.getName() + " out of uses\n");
                            game.removeObjectFromCurrentRoom(o);
                        }
                    }
                    else{
                       att.modify(v.getEffect()); 
                       done = true;
                    } 
            }

            if(done){
                updateAttribute(att, dep);
            }
            updatePlayerAttribute();
            updateTree();
            return true;
        }
        else{
            JLabel label = new JLabel("Object not found!");
            label.setFont(new Font("Tahoma", Font.PLAIN, 24));
            JOptionPane.showMessageDialog(jPanel1, 
                label, 
                "Object not found", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    /**
     * Prints out the conditions if the conditions are not met
     * @param t Transition to print out the conditions
     */
    private void conditionNotMet(Transition t){
        Gameplay.append("Condition not met: \n");
        for(Condition c: t.getConditions()){
            switch (c.getType()) {
                case BOOLEAN:
                    Gameplay.append(c.getAtt().getName() + 
                            " needs to be "
                            + String.valueOf(c.getValueBool()));
                    break;
                case NUMERICBT:
                    Gameplay.append(c.getAtt().getName()
                            + " needs to be bigger than "
                            + c.getValueAmt());
                    break;
                case NUMERICEQ:
                    Gameplay.append(c.getAtt().getName()
                            + " needs to be equal to "
                            + c.getValueAmt());
                    break;
                default:
                    Gameplay.append(c.getAtt().getName()
                            + " needs to be smaller than "
                            + c.getValueAmt());
                    break;
            }
            Gameplay.append("\n");
        }
    }
    
    /**
     * Appends the updated attribute to Game play text box
     * @param att Attribute to output value
     * @param dep Item associated with attribute
     */
    private void updateAttribute(Attribute att, String dep){
        if(att instanceof Boolean_Attribute){
           if(((Boolean_Attribute) att).getCondition()){
               Gameplay.append(dep + " is " + att.getName() + "\n"); 
           }
           else{
               Gameplay.append(dep + " is not " + att.getName() + "\n"); 
           }
        }
        else if(att instanceof Number_Attribute){
            if(((Number_Attribute) att).isIncrement()){
                Gameplay.append(att.getName() + " increase by " +
                        ((Number_Attribute) att).getAmount() + "\n"); 
            }
            else{
                Gameplay.append(att.getName() + " decreased by " + 
                        ((Number_Attribute) att).getAmount() + "\n"); 
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Play_Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Play_Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Play_Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Play_Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Play_Game().setVisible(true);
            }
        });
    }
    
    private void updatePlayerAttribute(){
        LinkedList<Attribute> a = game.getPlayer().getAttributes();
        DefaultTableModel player_attributes = 
                (DefaultTableModel) player_att.getModel();
        player_attributes.setRowCount(0);
        for(Attribute att: a){
            if(att instanceof Number_Attribute){
                player_attributes.addRow(new String[]{att.getName(), 
                    Double.toString(((Number_Attribute) att).getValue())});
            }
            else{
                player_attributes.addRow(new String[]{att.getName(), 
                    Boolean.toString(((Boolean_Attribute)att).getCondition())});
            }
        }
    }
    
    private void updateTree(){
    DefaultMutableTreeNode player = new DefaultMutableTreeNode("Inventory");
    for(Object o: game.getPlayerObject()){
        DefaultMutableTreeNode objNode;
        objNode = new DefaultMutableTreeNode(o);
        
        if(o instanceof Container){
            Container cont = (Container)o;
            for(Object c:cont.getObjects()){
                objNode.add(new DefaultMutableTreeNode(c));
            }
        }
        player.add(objNode);
    }
    inventory = new JTree(player);
    inventory.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
    expandAll(inventory);
    jScrollPane1.setViewportView(inventory);
    }
    
    public void expandAll(JTree tree) {
    TreeNode root = (TreeNode) tree.getModel().getRoot();
    expandAll(tree, new TreePath(root));
  }

  private void expandAll(JTree tree, TreePath parent) {
    TreeNode node = (TreeNode) parent.getLastPathComponent();
    if (node.getChildCount() >= 0) {
      for (Enumeration e = node.children(); e.hasMoreElements();) {
        TreeNode n = (TreeNode) e.nextElement();
        TreePath path = parent.pathByAddingChild(n);
        expandAll(tree, path);
      }
    }
    tree.expandPath(parent);
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Command;
    private javax.swing.JTextArea Gameplay;
    private javax.swing.JPanel Information;
    private javax.swing.JTree inventory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable player_att;
    private javax.swing.JButton save_game;
    // End of variables declaration//GEN-END:variables
}
