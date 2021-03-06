/**
 * 
 */
package jfm.model;

import jfm.lp.ConstraintBuilder;
import jfm.lp.LPX;
import jfm.lp.MatrixElement;
import jfm.lp.MatrixRow;
import jfm.lp.ModelComponent;
import jfm.lp.SOS2Primitive;
import jfm.lp.ConstraintBuilder.CBType;
import jfm.model.Types.ObjectiveType;

/**
 * @author iracooke
 *
 */
public class DitchLengthComponent extends BoundaryComponent {
	public DitchLengthComponent(double maxLen_,double hist,double createCost,double destCost,double maintain,double discountRate_){
		super(MCType.DITCHES,ObjectiveType.DITCHES,maxLen_,hist,createCost,destCost,maintain,discountRate_);
		this.addConstraintBuilder(new DitchesSOS2Constraints(CBType.DITCHESSOS2,MCType.DITCHES));
	}
	
	public class DitchesSOS2Constraints extends ConstraintBuilder {

		public DitchesSOS2Constraints(CBType type_,ModelComponent.MCType assoc){
			super(type_,assoc);
		}
		
		public void build(){
		//	System.out.println("Building hedge constraints");
			SOS2Primitive.buildConstraints(profit, matrix);
			if ( curve!=null){ // If we have set a curved attitude then we need to link it to profit
//				SOS2Primitive.buildConstraints(attitude, matrix);
		//		System.out.println("Building link");
				SOS2Primitive.buildLink(curve,profit,matrix);
			} else {
				// If there is no curve we need to bind the profit curve to the hedgerow counter directly
				int row=matrix.numRows();
				MatrixRow rowpointer =new MatrixRow(0,0,LPX.LPX_FX,
						row,"BindDitches","BindingRow");
				matrix.addRow(rowpointer);
				row++;
				rowpointer.addElement(new MatrixElement(profit.getDependentColumn(0),-1));
//				System.out.println("building binding row with "+obj.variables().size()+" "+obj.type);
				rowpointer.addElement(new MatrixElement(lengthCounter.column(),1));

				matrix.flagForAlwaysRebuild();
				
			}
		}
	}
}
