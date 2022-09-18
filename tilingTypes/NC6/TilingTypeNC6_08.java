package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_08
   extends TilingType
{
   public TilingTypeNC6_08(){
      super( "NC6-8", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 90, 50};
      paramName = new String[]{"Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,4, 0,4,5, 0},
            {0, 3,4, 1,0,5, 0},
            {1, 5,4, 2,4,5, 0},

            {0, 0,1, 1,1,2, 1},
            {1, 5,4, 4,4,5, 1},
            {0, 3,4, 5,0,5, 1},
            {1, 5,4, 6,4,5, 1},
      };
      info = "b=c=d\na+e=2b\nA+B=180\nB+C=360\nB=D\n(E+F=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double a = getParam(paramValues, 0)/2;
      double c = ln * Math.cos( a * DEG2RAD );
      double s = ln * Math.sin( a * DEG2RAD );
      double x = 2 * getParam(paramValues, 1)/100;

      baseTile.setPoint(0,   0,    0);
      baseTile.setPoint(1,   c,   -s);
      baseTile.setPoint(2, 2*c,    0);
      baseTile.setPoint(3, 3*c,   -s);
      baseTile.setPoint(4, (5-x)*c, (1-x)*s);
      baseTile.setPoint(5,  x*c, x*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[2].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(1)-tiles[3].getX(1);
      offsets[3] = tiles[1].getY(1)-tiles[3].getY(1);
   }
}