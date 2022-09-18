package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_144
   extends TilingType
{
   public TilingTypeNC5_144(){
      super( "NC5-144", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 75};
      paramName = new String[]{ "Aspect"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,4, 0,0,1, 0},
            {0, 4,1, 1,1,4, 0},
            {1, 0,1, 2,0,4, 0},
      };
      info = "a=b\nc=e\nA=B\nD+E=180\nC+D=360\n(D=2B)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 2;
      double w = lnt * getParam(paramValues,0)/200;
      double h = (lnt-w)*Math.sqrt(3)/2;
      double lna = Math.sqrt(w*w/4+h*h);
      double b = 2*Math.atan2(w/2,h);
      double c = Math.cos(b);
      double s = Math.sin(b);
      double dx = lna/4;
      double dy = dx*s/c;

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lna, 0);
      baseTile.setPoint(2,  lna -dx, dy);
      baseTile.setPoint(3,  lna*c+dx, lna*s-dy);
      baseTile.setPoint(4,  lna*c, lna*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(4)-tiles[3].getX(3);
      offsets[3] = tiles[0].getY(4)-tiles[3].getY(3);
   }
}
