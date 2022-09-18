package tilingTypes.N5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_03d
	extends TilingType
{
	public TilingTypeN5_03d(){
		super( "N5-3d: Type 3, Split Hexagon", 5, SymmetryType.p3 );

		paramMin = new int[]{0};
		paramMax = new int[]{100};
		paramDef = new int[]{30};
		paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,1, 0,0,4, 0},
            {0, 0,1, 1,0,4, 0},

            {1, 3,4, 0,2,3, 1},
            {1, 0,1, 3,0,4, 1},
            {1, 0,1, 4,0,4, 1},

            {2, 2,1, 2,3,4, 0},
            {2, 0,1, 6,0,4, 0},
            {2, 0,1, 7,0,4, 0},
      };
      info = "a=b\nd=c+e\nA=120\nC=120\nD=120\n(B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double f = getParam(paramValues, 0)/100.;
      double ln = .75;
      double h = ln * Math.sqrt(3)/2;

      baseTile.setPoint(0,          0,  0);
      baseTile.setPoint(1, ln*(1-f/2), -h*f);
      baseTile.setPoint(2,         ln,  0);
      baseTile.setPoint(3,       ln/2,  h);
      baseTile.setPoint(4,  ln*(f-.5),  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[7].getX(2);
      offsets[1] = tiles[0].getY(3)-tiles[7].getY(2);
      offsets[2] = tiles[1].getX(3)-tiles[3].getX(2);
      offsets[3] = tiles[1].getY(3)-tiles[3].getY(2);
   }
}
