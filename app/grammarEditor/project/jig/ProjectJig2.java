package org.fleen.forsythia.app.grammarEditor.project.jig;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.fleen.forsythia.app.grammarEditor.editor_Jig.model.JigEditingModelForCreate;
import org.fleen.forsythia.app.grammarEditor.editor_Jig.model.JigSectionEditingModel;
import org.fleen.forsythia.app.grammarEditor.project.metagon.ProjectMetagon;
import org.fleen.forsythia.app.grammarEditor.util.ElementMenuItem;
import org.fleen.forsythia.core.grammar.Jig;
import org.fleen.forsythia.core.grammar.JigSection;

/*
 * A Forsythia Jig in an editor-useful form
 * easy to edit
 * caced geometry and graphics
 * stuff for import and export
 */
public class ProjectJig2 implements ElementMenuItem{
  
  /*
   * ################################
   * CONSTRUCTORS
   * ################################
   */
  
  //create
  public ProjectJig2(
    JigEditingModelForCreate jigeditingmodel){
    targetmetagon=jigeditingmodel.targetmetagon;
    griddensity=jigeditingmodel.griddensity;
    tags=jigeditingmodel.getJigTags();
    initSectionsForCreate(jigeditingmodel);}
  
  //import
  public ProjectJig2(ProjectMetagon targetmetagon,Jig jig){
    this.targetmetagon=targetmetagon;
    this.griddensity=jig.griddensity;
    setTagsForImport(jig.getTags());
    initSectionsForImport(jig);}
  
  /*
   * ################################
   * TARGET METAGON
   * ################################
   */ 
  
  public ProjectMetagon targetmetagon;
  
  /*
   * ################################
   * GRID DENSITY
   * ################################
   */ 
  
  private int griddensity=1;
  
  public int getGridDensity(){
    return griddensity;}
  
  public void setGridDensity(int a){
    if(a<1)a=1;
    griddensity=a;}
  
  public double getFishFactor(){
    return 1.0/(double)griddensity;}
  
  /*
   * ################################
   * SECTIONS
   * ################################
   */
  
  public List<ProjectJigSection> sections=new ArrayList<ProjectJigSection>();

  //returns true of any of our sections uses the specified metagon for its polygonal product
  public boolean usesForProduct(ProjectMetagon m){
    for(ProjectJigSection pjs:sections)
      if(pjs.metagon==m)
        return true;
    return false;}
  
  /*
   * ++++++++++++++++++++++++++++++++
   * INIT SECTIONS FOR IMPORT
   * ++++++++++++++++++++++++++++++++
   */
  
  /*
   * At this point the project metagons list should be fully populated
   * Any metagon found in a jig (target or product) should be found in that list
   * if it isn't then we have an exception 
   */
  public void initSectionsForImport(Jig jig){
    ProjectJigSection pjspolygon;
    for(JigSection js:jig.sections){
      if(js instanceof JigSection){
         pjspolygon=new ProjectJigSection(this,(JigSection)js);
         sections.add(pjspolygon);}}
    ((ArrayList<ProjectJigSection>)sections).trimToSize();}
  
  /*
   * ++++++++++++++++++++++++++++++++
   * INIT SECTIONS FOR CREATE
   * ++++++++++++++++++++++++++++++++
   */
  
  private void initSectionsForCreate(JigEditingModelForCreate jigeditingmodel){
    for(JigSectionEditingModel jigsectioneditingmodel:jigeditingmodel.sections)
      sections.add(new ProjectJigSection(this,jigsectioneditingmodel));}
  
  /*
   * ################################
   * TAGS
   * ################################
   */
  
  public String tags="";
  
  private void setTagsForImport(List<String> tags){
    if(tags.isEmpty()){
      this.tags="";
      return;}
    StringBuffer a=new StringBuffer();
    for(String b:tags)
      a.append(b+" ");
    a.delete(a.length()-1,a.length());
    this.tags=a.toString();}
  
  public String[] getTagsForExport(){
    if(tags.equals(""))return new String[0];
    String[] a=tags.split(" ");
    return a;}
  
  /*
   * ################################
   * IMAGE
   * projectjig gets graphically rendered in one place: Overview bottom element menu. As a big icon.
   * It shares rendering components with the jigeditor.
   * imagepaths is cached and immutable.
   * overviewiconimage is cached. Invalidated on ui resize.
   * ################################
   */
  
  BufferedImage overviewiconimage=null;
  
  //implementation of UIElementMenuElement interface
  public BufferedImage getGrammarEditorIconImage(int span){
    if(overviewiconimage==null)
      overviewiconimage=new GrammarEditorIconImage(this,span);
    return overviewiconimage;}
  
  public void invalidateOverviewIconImage(){
    overviewiconimage=null;}
  
}