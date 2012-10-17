
/* First created by JCasGen Sat Oct 13 15:11:29 EDT 2012 */
package Model;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;


public class Sentence_Type extends Annotation_Type {

  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}

  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Sentence_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Sentence_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Sentence(addr, Sentence_Type.this);
  			   Sentence_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Sentence(addr, Sentence_Type.this);
  	  }
    };

  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Sentence.typeIndexID;

  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("Model.Sentence");
 

  final Feature casFeat_SentenceId;

  final int     casFeatCode_SentenceId;

  public String getSentenceId(int addr) {
        if (featOkTst && casFeat_SentenceId == null)
      jcas.throwFeatMissing("SentenceId", "Model.Sentence");
    return ll_cas.ll_getStringValue(addr, casFeatCode_SentenceId);
  }
   
  public void setSentenceId(int addr, String v) {
        if (featOkTst && casFeat_SentenceId == null)
      jcas.throwFeatMissing("SentenceId", "Model.Sentence");
    ll_cas.ll_setStringValue(addr, casFeatCode_SentenceId, v);}
    
  
 

  final Feature casFeat_textstring;

  final int     casFeatCode_textstring;

  public String getTextstring(int addr) {
        if (featOkTst && casFeat_textstring == null)
      jcas.throwFeatMissing("textstring", "Model.Sentence");
    return ll_cas.ll_getStringValue(addr, casFeatCode_textstring);
  }
  
  public void setTextstring(int addr, String v) {
        if (featOkTst && casFeat_textstring == null)
      jcas.throwFeatMissing("textstring", "Model.Sentence");
    ll_cas.ll_setStringValue(addr, casFeatCode_textstring, v);}
    
  




  public Sentence_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_SentenceId = jcas.getRequiredFeatureDE(casType, "SentenceId", "uima.cas.String", featOkTst);
    casFeatCode_SentenceId  = (null == casFeat_SentenceId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_SentenceId).getCode();

 
    casFeat_textstring = jcas.getRequiredFeatureDE(casType, "textstring", "uima.cas.String", featOkTst);
    casFeatCode_textstring  = (null == casFeat_textstring) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_textstring).getCode();

  }
}



    