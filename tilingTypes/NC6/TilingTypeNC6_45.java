package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_45
   extends TilingType
{
   public TilingTypeNC6_45(){
      super( "NC6-45", 6, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 50, 65};
      paramName = new String[]{"Aspect", "Indentation"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,5, 0,5,0, 0},
            {1, 0,1, 1,0,1, 1},
            {1, 0,5, 2,5,0, 1},
      };
      info = "c=d=e=f\nC=E\nC+D=360\n2B+C=360\n(A+F=B)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 2.0;
      double w = lntotal * getParam(paramValues, 0)/100;
      double h = lntotal - w;

      double f = getParam(paramValues, 1)/100 * 4 / 3;
      double w2 = w * f;
      double h2 = h/4;
      
      baseTile.setPoint(0,       0,     0);
      baseTile.setPoint(1,      w2,     0);
      baseTile.setPoint(2,       w,    h2);
      baseTile.setPoint(3,      w2,  2*h2);
      baseTile.setPoint(4,       w,  3*h2);
      baseTile.setPoint(5,      w2,  4*h2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(1)-tiles[1].getX(4);
      offsets[3] = tiles[0].getY(1)-tiles[1].getY(4);
   }
}