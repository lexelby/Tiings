package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_56
   extends TilingType
{
   public TilingTypeNC6_56(){
      super( "NC6-56", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,180};
      paramDef = new int[]{ 50, 20,140};
      paramName = new String[]{"Aspect", "Relative length", "Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,4, 0,1,2, 0},
            {1, 3,0, 1,0,3, 0},
            {0, 1,2, 2,5,4, 0},

            {0, 5,0, 1,3,4, 1},
            {1, 5,4, 4,1,2, 1},
            {1, 3,0, 5,0,3, 1},
            {0, 1,2, 6,5,4, 1},
      };
      info = "a=e\nb=d\nc=f\nB+C=360\nA+C+E=360\n(B+D+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double size = 1.5;
      double w = size * getParam(paramValues, 0)/100;
      double lntotal = size - w;

      double ln1 =  lntotal * getParam(paramValues, 1)/100;
      double ln2 = lntotal - ln1;
      double a = getParam(paramValues, 2);
      double c = ln2 * Math.cos((a-90) * DEG2RAD);
      double s = ln2 * Math.sin((a-90) * DEG2RAD);

      baseTile.setPoint(0,     0,   0);
      baseTile.setPoint(1,   ln1,   0);
      baseTile.setPoint(2, ln1+c,   s);
      baseTile.setPoint(3, ln1*2+c, s);
      baseTile.setPoint(4, ln1+c,   s+w);
      baseTile.setPoint(5,   ln1,   w);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[3].getX(5);
      offsets[1] = tiles[0].getY(4)-tiles[3].getY(5);
      offsets[2] = tiles[4].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[4].getY(2)-tiles[0].getY(0);
   }
}