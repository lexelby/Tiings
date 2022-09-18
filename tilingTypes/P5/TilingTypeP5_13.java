package tilingTypes.P5;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP5_13
	extends TilingType
{
	public TilingTypeP5_13(){
		super( "P5-13&15: Type 3, Split Hexagon", 5, SymmetryType.p3 );

		paramMin = new int[]{0};
		paramMax = new int[]{100};
		paramDef = new int[]{30};
		paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,1, 0,0,4, 0},
            {0, 0,1, 1,0,4, 0},
            };
      info = "a=b\nd=c+e\nA=120\nC=120\nD=120\n(B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double f = paramValues[0]/100.;
      double ln = .75;
      double h = ln * Math.sqrt(3)/2;

      baseTile.setPoint(0,          0,  0);
      baseTile.setPoint(1, ln*(1-f/2), -h*f);
      baseTile.setPoint(2,         ln,  0);
      baseTile.setPoint(3,       ln/2,  h);
      baseTile.setPoint(4,  ln*(f-.5),  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[1].getX(2);
      offsets[1] = tiles[0].getY(2)-tiles[1].getY(2);
      offsets[2] = tiles[2].getX(2)-tiles[1].getX(2);
      offsets[3] = tiles[2].getY(2)-tiles[1].getY(2);
   }
}
