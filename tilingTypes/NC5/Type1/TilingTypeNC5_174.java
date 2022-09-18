package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_174
   extends TilingType
{
   public TilingTypeNC5_174(){
      super( "NC5-174", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 50, 70};
      paramName = new String[]{ "Aspect", "Indent"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,3,4, 1},
            {1, 3,0, 1,0,3, 1},
            {0, 3,4, 2,4,0, 0},

            {0, 2,1, 0,1,0, 1},
            {1, 4,0, 4,3,4, 0},
            {1, 3,0, 5,0,3, 0},
            {0, 3,4, 6,4,0, 1},
      };
      info = "a=e\nb=d\nc=2b\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.5;
      double w = lnt * getParam(paramValues,0)/100;
      double h = lnt - w;
      w /= 2;
      
      double dy = h/2 * ( getParam(paramValues,1)/50-1 );
      
      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  w, dy );
      baseTile.setPoint(2,  3*w, -dy);
      baseTile.setPoint(3,  4*w, 0);
      baseTile.setPoint(4,  2*w, h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(1)-tiles[7].getX(2);
      offsets[3] = tiles[3].getY(1)-tiles[7].getY(2);
   }
}
