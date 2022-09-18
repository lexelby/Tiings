package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_83b
   extends TilingType
{
   public TilingTypeNC6_83b(){
      super( "NC6-83b", 6, SymmetryType.pg );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{100,100,100,100};
      paramDef = new int[]{ 50, 10, 50, 40};
      paramName = new String[]{"Aspect", "Relative Length", "X", "Y"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,0, 0,1,3, 1},
      };
      info = "a=d\nc=f\nC+F=360\nB+E=180\n(A+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.3;
      double w = lntotal * getParam(paramValues,0)/100;
      double h = lntotal - w;
      
      double w2 = w/2;
      double ind = w * (getParam(paramValues,1)/100 - .5);
      double y = h * getParam(paramValues,3)/100;
      double wy = w + (.5-y/h)*ind*4;
      double x = wy * getParam(paramValues,2)/100;

      double x0 = -w2-ind;
      double y0 = 0;
      double x1 =  w2+ind;
      double y1 = 0;
      double x2 = x1 - 2*y/h*ind - x;
      double y2 = y;
      double x3 = w2-ind;
      double y3 = h;
      double x4 = -w2+ind;
      double y4 = h;
      double x5 = x4 +x2-x1;
      double y5 = h-y;
      
      baseTile.setPoint(0, x0, y0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[0].getX(1);
      offsets[1] = tiles[0].getY(4)-tiles[0].getY(1);
      offsets[2] = tiles[1].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(3)-tiles[0].getY(0);
      offsets[0] += offsets[2]/2;
      offsets[1] += offsets[3]/2;
   }
}