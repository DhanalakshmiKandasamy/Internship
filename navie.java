package bigdataanalytics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 import com.mysql.jdbc.StringUtils;
import java.math.BigDecimal;
import sun.security.jca.GetInstance.Instance;
// import moa.classifiers.core.attributeclassobservers.AttributeClassObserver;
// import moa.core.AutoExpandVector;
//import moa.core.DoubleVector;
//import sun.security.jca.GetInstance.Instance;
 
/**
 *
 * @author ETPL-T4
 */
public class navie {   
    private static final long serialVersionUID = 1L;  
     String numAttributes;
    public String getPurposeString() {
        return "Naive Bayes classifier: performs classic bayesian prediction while making naive assumption that all inputs are independent.";
     }
    protected DoubleVector observedClassDistribution;  
 
    
    
    protected AutoExpandVector<AttributeClassObserver> attributeObservers;  
    public void resetLearningImpl() {
    this.observedClassDistribution = new DoubleVector();
        this.attributeObservers = new AutoExpandVector<AttributeClassObserver>();      
       
     }
 
     public void trainOnInstanceImpl(Instance inst) {
       //  this.observedClassDistribution.addToValue((int) inst.classValue(), inst.weight());
         for (int i = 0; i < inst.hashCode()- 1; i++) { 
             int instAttIndex = modelAttIndexToInstanceAttIndex(i, inst);
            AttributeClassObserver obs = (AttributeClassObserver) this.attributeObservers.get(i);
             if (obs == null) {
            //     obs = inst.attribute(instAttIndex).isNominal() ? newNominalClassObserver()
                    //   : newNumericClassObserver();
                 this.attributeObservers.set(i, obs);
             }
          //  obs.observeAttributeClass(inst.Value(instAttIndex), inst.classValue(), inst.weight());
         }
    }
 
    public double[] getVotesForInstance(Instance inst) {
         return doNaiveBayesPrediction(inst, this.observedClassDistribution,
                 this.attributeObservers);
     }

    protected Measurement[] getModelMeasurementsImpl() {
       return null;
     }
 
    public void getModelDescription(StringBuilder out, int indent) {
        for (int i = 0; i < this.observedClassDistribution.numValues(); i++) {
         //   StringUtils.appendIndented(out, indent, "Observations for ");
            out.append(getClassNameString());
             out.append(" = ");
             out.append(getClassLabelString(i));
             out.append(":");
//             StringUtils.appendNewlineIndented(out, indent + 1,
//                    "Total observed weight = ");
            out.append(this.observedClassDistribution.getValue(i));
             out.append(" / prob = ");
             out.append(this.observedClassDistribution.getValue(i)
);
            Object sumOfValues = this.observedClassDistribution.sumOfValues();
            for (int j = 0; j < this.attributeObservers.size(); j++) {
//                 StringUtils.appendNewlineIndented(out, indent + 1, 
//                         "Observations for ");
                out.append(getAttributeNameString(j));                 out.append(": ");
                // TODO: implement observer output
                out.append(this.attributeObservers.get(j));
           }
       //    StringUtils.consistentToString(BigDecimal.ZERO)Newline(out);
        }
     }
 
    // public boolean isRandomizable();
  //   
    private Object getAttributeNameString(int j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object getClassNameString() {
        throw new UnsupportedOperationException("Navie algorithm using mining data."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object getClassLabelString(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int modelAttIndexToInstanceAttIndex(int i, Instance inst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private AttributeClassObserver newNominalClassObserver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private AttributeClassObserver newNumericClassObserver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private double[] doNaiveBayesPrediction(Instance inst, DoubleVector observedClassDistribution, AutoExpandVector<AttributeClassObserver> attributeObservers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class Measurement {    

        public Measurement() {
        }
    }

    private static class DoubleVector {

        public DoubleVector() {
        }

        private int numValues() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private Object getValue(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private Object sumOfValues() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class AttributeClassObserver {

        public AttributeClassObserver() {
        }
    }

    private static class AutoExpandVector<T> {

        public AutoExpandVector() {
        }

        private Object get(int j) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private int size() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void set(int i, AttributeClassObserver obs) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
     }
 
//     protected AttributeClassObserver newNominalClassObserver() {  
//        return new NominalAttributeClassObserver();
//    }

//    protected AttributeClassObserver newNumericClassObserver() {
//         return new GaussianNumericAttributeClassObserver();
// 
// } 
//     public static double[] doNaiveBayesPrediction(Instance inst, 
//           DoubleVector observedClassDistribution,            AutoExpandVector<AttributeClassObserver> attributeObservers) {
//        double[] votes = new double[observedClassDistribution.numValues()];
//        double observedClassSum = observedClassDistribution.sumOfValues();
//     //   for (int classIndex = 0; classIndex < votes.length; classIndex++) {
//             votes[classIndex] = observedClassDistribution.getValue(classIndex)
//                     / observedClassSum;
//           for (int attIndex = 0; attIndex < inst.numAttributes() - 1; attIndex++) {   
//                int instAttIndex = modelAttIndexToInstanceAttIndex(attIndex,
//                         inst);                AttributeClassObserver obs = attributeObservers.get(attIndex);
//                if ((obs != null) && !inst.isMissing(instAttIndex)) {
//                    votes[classIndex] *= obs.probabilityOfAttributeValueGivenClass(inst.value(instAttIndex), classIndex);
//                 }
//             }
//         }
         // TODO: need logic to prevent underflow?
//        return votes;
// }; 
// 
//   public void manageMemory(int currentByteSize, int maxByteSize) {
//        // TODO Auto-generated method stub
//} 


 
    
    

