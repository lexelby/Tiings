package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_24a
   extends TilingType
{
   public TilingTypeN3_24a(){
      super( "N3-24a", 3, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 25};
      paramName = new String[]{ "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,2,1, 0},
            {2, 2,1, 1,1,2, 0},
            {2, 0,2, 2,2,0, 0},
            {1, 1,2, 3,2,1, 0},
            {0, 2,1, 4,0,1, 0},

            {0, 0,2, 3,1,0, 1},
            {1, 0,1, 6,2,1, 1},
            {2, 2,1, 7,1,2, 1},
            {2, 0,2, 8,2,0, 1},
            {1, 1,2, 9,2,1, 1},
            {0, 2,1,10,0,1, 1},
      };
      info = "2b=a+c\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln3 = .8;
      double ln1 = ln3/2 + ln3 * paramValues[0]/100.;
      double ln2 = 2*ln3-ln1;
      
      double an = calcAngle(ln1, ln3, ln2);
      double dx = ln1*Math.cos(an* DEG2RAD);
      double dy = ln1*Math.sin(an* DEG2RAD);

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, ln3,  0);
      baseTile.setPoint(2,  dx, dy);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[6].getX(1);
      offsets[1] = tiles[0].getY(2)-tiles[6].getY(1);
      offsets[2] = tiles[5].getX(1)-tiles[11].getX(2);
      offsets[3] = tiles[5].getY(1)-tiles[11].getY(2);
   }
}
