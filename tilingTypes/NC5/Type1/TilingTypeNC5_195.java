package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_195
   extends TilingType
{
   public TilingTypeNC5_195(){
      super( "NC5-195", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,3,4, 0},
            {1, 1,2, 1,2,1, 0},
            {0, 4,3, 2,3,4, 0},

            {0, 4,0, 0,2,3, 1},
            {1, 4,3, 4,3,4, 1},
            {1, 1,2, 5,2,1, 1},
            {0, 4,3, 6,3,4, 1},
      };
      info = "b=a+c\na=d\nA=C\nB+C=360\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnb = 0.8;
      double lnc = lnb * getParam(paramValues,1)/100*2 / (Math.sqrt(5)+3);
      double lnad = lnb - lnc;
      
      double a = getParam(paramValues,0);
      double c = Math.cos(a * DEG2RAD);
      double s = Math.sin(a * DEG2RAD);
      
      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lnb, 0);
      baseTile.setPoint(2,  lnb - lnc*c, -lnc*s);
      baseTile.setPoint(3,  lnb + lnad - lnc*c, -lnc*s);
      baseTile.setPoint(4,  lnad*c, lnad*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(1)-tiles[1].getX(0);
      offsets[1] = tiles[7].getY(1)-tiles[1].getY(0);
      offsets[2] = tiles[4].getX(2)-tiles[0].getX(4);
      offsets[3] = tiles[4].getY(2)-tiles[0].getY(4);
   }
}
