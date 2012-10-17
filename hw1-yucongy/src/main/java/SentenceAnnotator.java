import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.chunk.NBestChunker;
import com.aliasi.util.AbstractExternalizable;
import com.aliasi.util.ScoredObject;
import com.aliasi.util.Strings;
import java.lang.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import java.io.File;
import java.util.Iterator;

import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

import Model.Sentence;

/**
 * @see SentenceAnnotator This is SentenceAnnotator class that contains the main function we need---Process
 */
/**@author Yucong Yang*/
public class SentenceAnnotator extends JCasAnnotator_ImplBase {
  /**
   *@see <p>process(JCas aJCas) method implements select the sample.in from the trained model<br> 
   *and add annotators if find one that suitable to the lingpipe
   */
  public void process(JCas aJCas) {
    
    int end = 0,start = 0;
    int counter = 0;
    int temp1;
    int temp2;
    String temp3 = null; 
    File modelFile = new File("src/main/resources/ne-en-bio-genetag.HmmChunker");
    System.out.println("Reading chunker from file=" + modelFile);
    ConfidenceChunker chunker = null;
    int position = 0;
    try {
      chunker = (ConfidenceChunker)AbstractExternalizable.readObject(modelFile);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    /**
     *start get document from the ajcas
     *aJCas contains the whole features we want to
     */
    String docText = aJCas.getDocumentText();
    String[] b = docText.split("\n");
    for (int i = 0; i < b.length; i++) 
    {
        if(b[i].length()<14)
          continue;
        temp3 = b[i].substring(0, 14);
        b[i] = b[i].substring(15, b[i].length());
        char[] cs = b[i].toCharArray();
        Iterator<Chunk> it= chunker.nBestChunks(cs,0,cs.length,6);//I use 6-best strategy
        for (int n = 0; it.hasNext(); ++n) 
        {
            Chunk chunk = it.next();
            double conf = Math.pow(2.0,chunk.score());
            if(conf < 0.1) /**
            *I set the threshold to be 0.1,all the data confidence less than 0.1 will be rejected
            */
            {
              continue;
            }
            start = chunk.start();
            end = chunk.end();
            temp1 = calculate(cs,0,start);
            temp2 = calculate(cs,0,end-1);
            String phrase = b[i].substring(start,end);
            Sentence annotation = new Sentence(aJCas);
            //System.out.println(temp3+"|"+(start-temp1)+" "+(end-1-temp2)+"|"+phrase); //for test
            annotation.setBegin(start-temp1);
            annotation.setEnd(end-1-temp2);
            annotation.setTextstring(phrase);
            annotation.setSentenceId(temp3);
            annotation.addToIndexes();
       }
    }
    
 }
  /**
   *@see #calculate(char[] temp,int start, int end)
   *@param temp to be extracted char array
   *@return counter to counter the whitespace numbers
   */
public int calculate(char[] temp,int start, int end)
{
  int counter = 0;
  for(int i = start;i <= end;i++)
  {
      if(' '==temp[i])
      {
          counter++;
      }
  }
          
  return counter;
}
}

