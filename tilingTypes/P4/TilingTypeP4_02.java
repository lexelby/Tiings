package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_02
	extends TilingType
{
	public TilingTypeP4_02(){
		super( "P4-2&18&21&22&51&54: Strips alternating", 5, SymmetryType.pg );
 
		paramMin = new int[]{  0,  0,  0};
		paramMax = new int[]{180,100,100};
		paramDef = new int[]{100, 30, 10};
		paramName = new String[]{ "Angle", "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,4, 0,2,1, 1},
            };
      labels = new int[]{0,1,-1,2,3};
      info = "a=c\nb=d\nA+B=180\nA=C\n(B=D)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 2*paramValues[1]/100.;
      double ln3 = 2-w;
      double d = w*Math.tan( (paramValues[0]-90) * DEG2RAD);
      double off = getParam( paramValues,2)/100.;

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, w, d);
      baseTile.setPoint(2, w, d+ln3*off);
      baseTile.setPoint(3, w, d+ln3);
      baseTile.setPoint(4, 0, ln3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(4)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(4)-tiles[0].getY(0);
   }
}
