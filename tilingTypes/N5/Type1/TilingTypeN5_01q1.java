package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01q1
   extends TilingType
{
   public TilingTypeN5_01q1(){
      super( "N5-1q1", 5, SymmetryType.pg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{360,100};
      paramDef = new int[]{150, 60};
      paramName = new String[]{ "Angle", "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,3,4, 1},
            {1, 1,2, 0,2,3, 1},
            {0, 3,4, 2,3,4, 0},
            
            {0, 1,0, 1,0,1, 1},
            {1, 3,4, 4,3,4, 0},
            {1, 1,2, 4,2,3, 0},
            {0, 3,4, 6,3,4, 1},
      };
      info = "a=c=d\nD+E=180\nC=2E\n(A+B+C=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 1.5 * paramValues[1]/100;
      double ln2 = 1.5 - ln1;
      double b = paramValues[0]/2.;

      double c = ln2 * Math.cos( b * DEG2RAD);
      double s = ln2 * Math.sin( b * DEG2RAD);

      baseTile.setPoint(0,     0, 0);
      baseTile.setPoint(1, ln1-c,-s);
      baseTile.setPoint(2,   ln1, 0);
      baseTile.setPoint(3, ln1-c, s);
      baseTile.setPoint(4,    -c, s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(0)-tiles[0].getX(4);
      offsets[1] = tiles[2].getY(0)-tiles[0].getY(4);
      offsets[2] = tiles[5].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[5].getY(1)-tiles[0].getY(0);
   }
}
