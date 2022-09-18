package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_07
	extends TilingType
{
	public TilingTypeP4_07(){
		super( "P4-7: Strip pairs alternating, half offset", 6, SymmetryType.pgg );
 
		paramMin = new int[]{  0,  0,  0};
		paramMax = new int[]{180,100,100};
		paramDef = new int[]{100, 30, 10};
		paramName = new String[]{ "Angle", "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,3, 0,3,2, 0},
            {0, 0,5, 1,5,4, 1},
            {0, 2,3, 2,3,2, 1},
            };
      labels = new int[]{0,1,-1,2,3,-1};
      info = "a=c\nb=d\nA+B=180\nA=C\n(B=D)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 2*paramValues[1]/100.;
      double ln3 = 2-w;
      double os = getParam( paramValues,2)/100.; // strip offset
      double t = w*Math.tan( (paramValues[0]-90) * DEG2RAD);
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, w, t);
      baseTile.setPoint(2, w, t+ln3*os );
      baseTile.setPoint(3, w, t+ln3);
      baseTile.setPoint(4, 0, ln3);
      baseTile.setPoint(5, 0, ln3/2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(5)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(5)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(4)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(4)-tiles[0].getY(0);
   }
}
