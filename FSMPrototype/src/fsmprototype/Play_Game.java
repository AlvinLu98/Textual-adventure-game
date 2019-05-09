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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
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
        JOptionPane.showMessageDialog(jScrollPane1, "Currently creating your game!");
        
        movement = new ArrayList();
        observe = new ArrayList();
        takeItem = new ArrayList();
        dropItem = new ArrayList();
        initWordList();
        
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        pipeline = new StanfordCoreNLP(props);
        if(game != null){
            Gameplay.append("Welcome " + game.getPlayer().getName() + "\n");
            Gameplay.append(game.getPlayer().getDesc()+ "\n");
            roomChange();
        }
        else{
            Gameplay.append("Your game is currently empty! Please insert a player and room!");
        }
    }
    
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
    }
    
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Command.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Command.setText("Enter command");
        Command.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommandActionPerformed(evt);
            }
        });

        Gameplay.setColumns(20);
        Gameplay.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        Gameplay.setRows(5);
        jScrollPane2.setViewportView(Gameplay);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1183, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        jLabel1.setText("Player info");

        jLabel2.setText("Inventory");

        updateTree();
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(InformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InformationLayout.setVerticalGroup(
            InformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Command, javax.swing.GroupLayout.PREFERRED_SIZE, 1501, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Information, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Information, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Command, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommandActionPerformed
        String text = Command.getText();
        Command.setText("   ");
        
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
                System.out.println(word + ", " + pos + ", " + ne);
            }
            SemanticGraph dependencies = sentence.get(CollapsedDependenciesAnnotation.class);
            System.out.println("Dependencies\n:" + dependencies);
            ArrayList<TypedDependency> dep = (ArrayList)dependencies.typedDependencies();
            processSentence(dep);
        }
    }//GEN-LAST:event_CommandActionPerformed

    private void processSentence(ArrayList<TypedDependency> d){
        String rel, gov, dep;
        String compund;
        for(int i = 0; i < d.size(); i++){
            rel = d.get(i).reln().toString();
            gov = d.get(i).gov().word();
            dep = d.get(i).dep().word();
            System.out.println(rel + ", "+ gov +", "+ dep);
            
            if(dep.equals("help") && rel.equals("root")){
               Gameplay.append("Good luck!");
            }
            
            if(isMovement(rel, gov, dep)){
                Room r = game.getPlayer().move(dep);
                if(r == null){
                    Gameplay.append("No such direction!\n");
                }
                else{
                    roomChange();
                }
            }
            else if(isMovement_dep(rel, gov, dep)){
                if(game.getPlayer().move(gov) == null){
                    Gameplay.append("No such direction!\n");
                }
                else{
                    roomChange();
                }
            }
            else if(isObserving(rel, gov, dep)){
                Gameplay.append(game.findObjectInRoomByName(dep).getDesc());
                Gameplay.append("You can: ");
                for(Verb v:game.findObjectInRoomByName(dep).getVerbs()){
                    Gameplay.append(v.getName() + ", ");
                }
                Gameplay.append("\n");
            }
            else if(isTaking(rel, gov, dep)){
                Object o = game.findObjectInRoomByName(dep);
                if(o != null){
                    game.givePlayer(o);
                    Gameplay.append("Taken " + o.getName() + "\n");
                    updateTree();
                }
                else{
                    Gameplay.append("No such object!\n");
                }
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
            }
            else if(isAction(rel, gov, dep)){
                processVerbs(rel, gov, dep);
            }
        }
    }
    
    private boolean isMovement(String rel, String gov, String dep){
        if(rel.contains("advmod")){
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
    
    private boolean isMovement_dep(String rel, String gov, String dep){
        if(rel.contains("nsubj") || rel.contains("nmod:to") || rel.contains("nmod")){
            if(movement.contains(dep)){
                return true;
            }
        }
        return false;
    }
    
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
    
    private boolean isTaking(String rel, String gov, String dep){
        if(rel.contains("dobj")){
            if(takeItem.contains(gov)){
                return true;
            }
        }
        return false;
    }
    
    private boolean isDropping(String rel, String gov, String dep){
        if(rel.contains("dobj")){
            if(dropItem.contains(gov)){
                return true;
            }
        }
        
        return false;
    }
    
    private boolean isDropping_dep(String rel, String gov, String dep){
        if(rel.contains("compound")){
            if(dropItem.contains(dep)){
                return true;
            }
        }
        return false;
    }
    
    private boolean isAction(String rel, String gov, String dep){
        if(rel.contains("dobj") || rel.contains("nmod:npmod") || rel.contains("nmod:on")){
            return true;
        }
        return false;
    }    
    
    private void processVerbs(String rel, String gov, String dep){
        boolean done = false;
        Object o = game.findAssociatedObjinVerb(gov, dep);
        System.out.println("gov: " + gov);
        Attribute att = game.findAttByAssociatedObject(gov, o);
        if(att == null){
            JOptionPane.showMessageDialog(jPanel1, 
                    "Object not found!", 
                    "Object not found", JOptionPane.WARNING_MESSAGE);
        }
        else if(att.inRoom()){
            if(game.findObjectInRoomByName(att.getVerb().getOwnerObject().getName()) != null){
                att.modify();
            }
            else{
                Gameplay.append(att.getVerb().getOwnerObject().getName() + " cannot be used here!"); 
            }
        }
        else{
            att.modify();
        }
        if(att instanceof Boolean_Attribute){
           if(((Boolean_Attribute) att).getCondition()){
               Gameplay.append(dep + " is " + att.getName()); 
           }
           else{
               Gameplay.append(dep + " is not " + att.getName()); 
           }
        }
        else if(att instanceof Number_Attribute){
            if(((Number_Attribute) att).isIncrement()){
                Gameplay.append(att.getName() + " increase by " + ((Number_Attribute) att).getAmount() + "\n"); 
            }
            else{
                Gameplay.append(att.getName() + "decreased by " + ((Number_Attribute) att).getAmount() + "\n"); 
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
        DefaultTableModel player_attributes = (DefaultTableModel) player_att.getModel();
        player_attributes.setRowCount(0);
        for(Attribute att: a){
            if(att instanceof Number_Attribute){
                player_attributes.addRow(new String[]{att.getName(), Double.toString(((Number_Attribute) att).getValue())});
            }
            else{
                player_attributes.addRow(new String[]{att.getName(), Boolean.toString(((Boolean_Attribute)att).getCondition())});
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable player_att;
    // End of variables declaration//GEN-END:variables
}
