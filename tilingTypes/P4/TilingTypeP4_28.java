package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_28
	extends TilingType
{
	public TilingTypeP4_28(){
		super( "P4-28: Strip pairs, no offset", 4, SymmetryType.p2 );
 
		paramMin = new int[]{  0,  0,  0};
		paramMax = new int[]{180,100,100};
		paramDef = new int[]{100, 30, 20};
		paramName = new String[]{ "Angle", "Relative Length", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,2,1, 0},
            };
      info = "a=c\nb=d\nA+B=180\nA=C\n(B=D)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 2*paramValues[1]/100.;
      double ln3 = 2-w;
      double t = w * Math.tan( (paramValues[0]-90) * DEG2RAD);
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1,   w, t);
      baseTile.setPoint(2,   w, t+ln3 );
      baseTile.setPoint(3,   0, ln3);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = paramValues[2]/100.;
      offsets[0] = tiles[1].getX(0)*os+tiles[1].getX(3)*(1-os)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(0)*os+tiles[1].getY(3)*(1-os)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(3)-tiles[0].getY(0);
   }
}
