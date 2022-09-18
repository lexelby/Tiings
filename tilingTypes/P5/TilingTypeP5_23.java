package tilingTypes.P5;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP5_23
   extends TilingType
{
   public TilingTypeP5_23(){
      super( "P5-23&24: Type 4, Crosses", 5, SymmetryType.p4 );

      paramMin = new int[]{ 90,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{130, 35};
      paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,1,0, 0},
            {0, 1,2, 1,1,0, 0},
            {0, 1,2, 2,1,0, 0},
            };
      info = "b=c\nd=e\nB=90\nD=90\n(A+C+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      // tile is general triangle with 45-90-45 triangles added on two sides.

      double ln1 = paramValues[1]/100.;
      double ln2 = 1-ln1;
      double s = ln2 * Math.sin( (paramValues[0]-90) * DEG2RAD);
      double c = ln2 * Math.cos( (paramValues[0]-90) * DEG2RAD);

      baseTile.setPoint(0,   0,ln1);
      baseTile.setPoint(1,   0,  0);
      baseTile.setPoint(2, ln1,  0);
      baseTile.setPoint(3, ln1+c, s);
      baseTile.setPoint(4, ln1+c-s, s+c);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[2].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[1].getX(4);
      offsets[3] = tiles[0].getY(2)-tiles[1].getY(4);
   }
}
