

/* First created by JCasGen Sat Oct 13 15:11:29 EDT 2012 */
package Model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;

public class Sentence extends Annotation {

  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Sentence.class);

  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  protected Sentence() {/* intentionally empty block */}
    
  public Sentence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  public Sentence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  public Sentence(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  private void readObject() {/*default - does nothing empty block */}
     
 
    

  public String getSentenceId() {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_SentenceId == null)
      jcasType.jcas.throwFeatMissing("SentenceId", "Model.Sentence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Sentence_Type)jcasType).casFeatCode_SentenceId);}
    

  public void setSentenceId(String v) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_SentenceId == null)
      jcasType.jcas.throwFeatMissing("SentenceId", "Model.Sentence");
    jcasType.ll_cas.ll_setStringValue(addr, ((Sentence_Type)jcasType).casFeatCode_SentenceId, v);}    
   
    

  public String getTextstring() {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_textstring == null)
      jcasType.jcas.throwFeatMissing("textstring", "Model.Sentence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Sentence_Type)jcasType).casFeatCode_textstring);}
    

  public void setTextstring(String v) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_textstring == null)
      jcasType.jcas.throwFeatMissing("textstring", "Model.Sentence");
    jcasType.ll_cas.ll_setStringValue(addr, ((Sentence_Type)jcasType).casFeatCode_textstring, v);}    
  }

    