package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_203
   extends TilingType
{
   public TilingTypeNC5_203(){
      super( "NC5-203", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 60, 50};
      paramName = new String[]{ "Aspect", "Indent"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 2,0, 1,0,2, 1},
            {0, 0,1, 2,0,1, 0},
      };
      info = "a=d\nA=B\nC=E\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 0.7;
      double w = lnt * getParam(paramValues,0)/100;
      double h = lnt - w;

      double k = h/w;
      double dx = w * getParam(paramValues,1)/100;

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  4*w, 0);
      baseTile.setPoint(2,  w*2+dx, (w*2-dx)*k);
      baseTile.setPoint(3,  w+dx, (w-dx)*k);
      baseTile.setPoint(4,  w, h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[3].getX(2);
      offsets[1] = tiles[0].getY(3)-tiles[3].getY(2);
      offsets[2] = tiles[0].getX(1)-tiles[0].getX(4);
      offsets[3] = tiles[0].getY(1)-tiles[0].getY(4);
   }
}
