package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_08j
   extends TilingType
{
   public TilingTypeNC5_08j(){
      super( "NC5-8j", 6, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 50, 30};
      paramName = new String[]{ "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 4,5, 0,5,4, 0},
            {1, 5,0, 1,5,0, 1},
            {2, 1,2, 0,2,1, 0},
            {0, 4,5, 3,5,4, 0},
            {1, 5,0, 4,5,0, 1},
      };
      info = "b=c=d\ne=3b\nB+C=360\n2A=C\n(A+D+E=180)";
      labels = new int[]{0,1,2,3,-1,4};
   }
   
   public void recalcBase(double[] paramValues) {
      double lnb = .6*paramValues[0]/100.;   // base length
      double lnh = (.6 - lnb)*3/4; // teeth height
      double os = paramValues[1]/100.;   // offset

      double x1 = lnb;
      double y1 = lnh;
      double x2 = 2*lnb;
      double y2 = 0;
      double x3 = 3*lnb;
      double y3 = lnh;
      double x4 = 0;
      double y4 = 4*lnh;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, os*x3+(1-os)*x4, os*y3+(1-os)*y4);
      baseTile.setPoint(5, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(5);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(5);
      offsets[2] = tiles[2].getX(0)-tiles[5].getX(1);
      offsets[3] = tiles[2].getY(0)-tiles[5].getY(1);
   }
}
