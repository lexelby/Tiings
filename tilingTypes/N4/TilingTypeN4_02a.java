package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_02a
	extends TilingType
{
	public TilingTypeN4_02a(){
		super( "N4-2a", 4, SymmetryType.p2);

		paramMin = new int[]{  0};
		paramMax = new int[]{100};
		paramDef = new int[]{  0};
		paramName = new String[]{ "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,2,1, 0},
            {2, 1,2, 0,2,3, 1},

            {0, 0,3, 2,0,3, 0},
            {1, 0,1, 3,2,1, 0},
            {2, 1,2, 3,2,3, 1},
      };
      info = "b=c=d\nB=90\nC+2D=360\n(2A+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .7;
      double b = 90-2* Math.atan( .5) / DEG2RAD;

      double x3 = ln - ln*Math.cos( b * DEG2RAD);
      double y3 = ln - ln*Math.sin( b * DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, ln, ln);
      baseTile.setPoint(3, x3, y3);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = paramValues[0]/100.;
      offsets[0] = tiles[1].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(0)-tiles[0].getX(0) + os*offsets[0];
      offsets[3] = tiles[2].getY(0)-tiles[0].getY(0) + os*offsets[1];
   }
}
